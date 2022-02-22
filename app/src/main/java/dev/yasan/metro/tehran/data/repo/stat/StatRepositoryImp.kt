package dev.yasan.metro.tehran.data.repo.stat

import android.util.Log
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.dao.*
import dev.yasan.metro.tehran.data.db.entity.Stat
import dev.yasan.metro.tehran.data.db.entity.StatComplex
import dev.yasan.metro.tehran.data.repo.station.StationRepository
import javax.inject.Inject

/**
 * The main implementation of [StatRepository].
 */
class StatRepositoryImp @Inject constructor(
    private val intersectionDAO: IntersectionDAO,
    private val lineDAO: LineDAO,
    private val stationRepository: StationRepository
) : StatRepository {

    companion object {
        private const val TAG = "StatRepositoryImp"
    }

    override suspend fun getBasicStatistics(): List<Stat> {
        val stations = stationRepository.getStations(
            complete = true,
            removeDuplicate = true
        )

        val intersectionCount = intersectionDAO.getAll().size
        val lineCount = lineDAO.getAll().size
        val stationCount = stations.size

        return listOf(
            Stat(titleStringResourceId = R.string.stations, stationCount),
            Stat(titleStringResourceId = R.string.intersections, intersectionCount),
            Stat(titleStringResourceId = R.string.lines, lineCount),
        )

    }

    override suspend fun getComplexStatistics(): List<StatComplex> {

        val stations =
            stationRepository.getStations(complete = false, removeDuplicate = true)

        val withEmsPercentage = toPercentage(
            value = stations.filter { it.hasEmergencyMedicalServices }.size,
            total = stations.size
        )
        val withoutEmsPercentage = toPercentage(
            value = stations.filter { !it.hasEmergencyMedicalServices }.size,
            total = stations.size
        )
        val blindLevel1Percentage = toPercentage(
            value = stations.filter { it.accessibilityBlindnessInt == 1 }.size,
            total = stations.size
        )
        val blindLevel2Percentage = toPercentage(
            value = stations.filter { it.accessibilityBlindnessInt == 2 }.size,
            total = stations.size
        )
        val blindLevel3Percentage = toPercentage(
            value = stations.filter { it.accessibilityBlindnessInt == 3 }.size,
            total = stations.size
        )
        val wheelchairLevel1Percentage = toPercentage(
            value = stations.filter { it.accessibilityWheelchairInt == 1 }.size,
            total = stations.size
        )
        val wheelchairLevel2Percentage = toPercentage(
            value = stations.filter { it.accessibilityWheelchairInt == 2 }.size,
            total = stations.size
        )
        val wheelchairLevel3Percentage = toPercentage(
            value = stations.filter { it.accessibilityWheelchairInt == 3 }.size,
            total = stations.size
        )
        val wheelchairLevel4Percentage = toPercentage(
            value = stations.filter { it.accessibilityWheelchairInt == 4 }.size,
            total = stations.size
        )
        val wheelchairLevel5Percentage = toPercentage(
            value = stations.filter { it.accessibilityWheelchairInt == 5 }.size,
            total = stations.size
        )

        return listOf(
            StatComplex(
                titleEn = "Emergency medical services available",
                titleFa = "دارای خدمات اورژانس پزشکی",
                value = withEmsPercentage
            ),
            StatComplex(
                titleEn = "Emergency medical services not available",
                titleFa = "فاقد خدمات اورژانس پزشکی",
                value = withoutEmsPercentage
            ),
            StatComplex(
                titleEn = "Not accessible to the visually impaired",
                titleFa = "فاقد مسیر نابینایان",
                value = blindLevel1Percentage,
            ),
            StatComplex(
                titleEn = "Accessible to the visually impaired on platforms only",
                titleFa = "دارای مسیر نابینابان در سکو\u200Cها",
                value = blindLevel2Percentage,
            ),
            StatComplex(
                titleEn = "Accessible to the visually impaired",
                titleFa = "دارای مسیر نابینایان در تمام ایستگاه",
                value = blindLevel3Percentage,
            ),
            StatComplex(
                titleEn = "Not wheelchair accessible",
                titleFa = "با ویلچر قابل دسترسی نیست",
                value = wheelchairLevel1Percentage,
            ),
            StatComplex(
                titleEn = "Elevator from street to one platform",
                titleFa = "آسانسور از سطح خیابان به یک سکو",
                value = wheelchairLevel2Percentage,
            ),
            StatComplex(
                titleEn = "Elevator from street to both platforms",
                titleFa = "آسانسور از سطح خیابان به هر دو سکو",
                value = wheelchairLevel3Percentage,
            ),
            StatComplex(
                titleEn = "Elevator from ticket sales hall to platform",
                titleFa = "آسانسور از سالن فروش بلیت به سکو",
                value = wheelchairLevel4Percentage,
            ),
            StatComplex(
                titleEn = "Elevator from street to ticket sales hall & from ticket sales hall to platform",
                titleFa = "آسانسور از سطح خیابان به سالن فروش بلیت و از سالن فروش بلیت به سکو",
                value = wheelchairLevel5Percentage,
            )
        )
    }

}

fun toPercentage(value: Int, total: Int): String =
    "${"%.2f".format((value.toDouble() / total.toDouble()) * 100)}%"
