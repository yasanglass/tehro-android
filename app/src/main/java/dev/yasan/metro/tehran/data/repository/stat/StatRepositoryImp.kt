package dev.yasan.metro.tehran.data.repository.stat

import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.source.local.database.dao.IntersectionDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.LineDAO
import dev.yasan.metro.tehran.domain.entity.stat.Stat
import dev.yasan.metro.tehran.domain.entity.stat.StatComplex
import dev.yasan.metro.tehran.domain.repository.accessibility.AccessibilityRepository
import dev.yasan.metro.tehran.domain.repository.stat.StatRepository
import dev.yasan.metro.tehran.domain.repository.station.StationRepository
import javax.inject.Inject

/**
 * The main implementation of [StatRepository].
 */
class StatRepositoryImp @Inject constructor(
    private val intersectionDAO: IntersectionDAO,
    private val lineDAO: LineDAO,
    private val stationRepository: StationRepository,
    private val accessibilityRepository: AccessibilityRepository
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
        // FIXME Adjust the return type to support resourceIds

        val stations =
            stationRepository.getStations(complete = false, removeDuplicate = true)

        val list = ArrayList<StatComplex>()

        val withEmsPercentage = toPercentage(
            value = stations.filter { it.hasEmergencyMedicalServices }.size,
            total = stations.size
        )
        val withoutEmsPercentage = toPercentage(
            value = stations.filter { !it.hasEmergencyMedicalServices }.size,
            total = stations.size
        )

        list.addAll(
            listOf(
                StatComplex(
                    titleEn = "Emergency medical services",
                    titleFa = "خدمات اورژانس پزشکی"
                ),
                StatComplex(
                    titleEn = "Emergency medical services not available",
                    titleFa = "فاقد خدمات اورژانس پزشکی",
                    value = withoutEmsPercentage
                ),
                StatComplex(
                    titleEn = "Emergency medical services available",
                    titleFa = "دارای خدمات اورژانس پزشکی",
                    value = withEmsPercentage
                ),
            )
        )

        list.add(
            StatComplex(
                titleEn = "Visually Impaired",
                titleFa = "نابینایان"
            )
        )

        accessibilityRepository.getBlindnessAccessibilityList().forEach { level ->
            list.add(
                StatComplex(
                    titleEn = level.descriptionEn,
                    titleFa = level.descriptionFa,
                    value = toPercentage(
                        value = stations.filter { station -> station.accessibilityBlindnessInt == level.id }.size,
                        total = stations.size
                    ),
                )
            )
        }

        list.add(
            StatComplex(
                titleEn = "Wheelchair",
                titleFa = "ویلچر"
            )
        )

        accessibilityRepository.getWheelchairAccessibilityList().forEach { level ->
            list.add(
                StatComplex(
                    titleEn = level.descriptionEn,
                    titleFa = level.descriptionFa,
                    value = toPercentage(
                        value = stations.filter { station -> station.accessibilityWheelchairInt == level.id }.size,
                        total = stations.size
                    ),
                )
            )
        }

        list.add(
            StatComplex(
                titleEn = "Restroom",
                titleFa = "سرویس بهداشتی",
            )
        )

        accessibilityRepository.getWcAvailabilityLevels().forEach { level ->
            list.add(
                StatComplex(
                    titleEn = level.descriptionEn,
                    titleFa = level.descriptionFa,
                    value = toPercentage(
                        value = stations.filter { station -> station.wcInt == level.id }.size,
                        total = stations.size
                    ),
                )
            )
        }

        return list
    }
}

fun toPercentage(value: Int, total: Int): String =
    "${"%.2f".format((value.toDouble() / total.toDouble()) * 100)}%"
