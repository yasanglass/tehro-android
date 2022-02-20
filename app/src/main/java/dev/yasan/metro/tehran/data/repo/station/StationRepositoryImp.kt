package dev.yasan.metro.tehran.data.repo.station

import android.util.Log
import dev.yasan.metro.tehran.data.db.dao.StationDAO
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.data.repo.intersection.IntersectionRepository
import dev.yasan.metro.tehran.data.repo.line.LineRepository
import dev.yasan.metro.tehran.data.repo.station.accessibility.AccessibilityRepository
import javax.inject.Inject

/**
 * The main implementation of [StationRepository].
 */
class StationRepositoryImp @Inject constructor(
    private val stationDAO: StationDAO,
    private val intersectionRepository: IntersectionRepository,
    private val lineRepository: LineRepository,
    private val accessibilityRepository: AccessibilityRepository
) : StationRepository {

    companion object {
        private const val TAG = "StationRepositoryImp"
    }

    override suspend fun getStations(lineId: Int, complete: Boolean): List<Station> {
        val stations = stationDAO.getByLineId(lineId = lineId)
        return if (complete) fetchAdditionalStationData(stations = stations)
        else stations
    }

    override suspend fun getStation(stationId: Int, complete: Boolean): Station? {
        val station = stationDAO.getById(stationId = stationId)
        return if (station == null || !complete) station
        else fetchAdditionalStationData(station = station)
    }

    override suspend fun fetchAdditionalStationData(station: Station): Station {
        intersectionRepository.getIntersectionByStationId(stationId = station.id)
            ?.let { intersection ->
                intersection.stationA =
                    getStation(stationId = intersection.stationIdA)?.apply {
                        line = lineRepository.getLine(lineId = this.lineId)
                    }
                intersection.stationB =
                    getStation(stationId = intersection.stationIdB)?.apply {
                        line = lineRepository.getLine(lineId = this.lineId)
                    }
                if (intersection.hasBothStations()) {
                    station.intersection = intersection
                }
            }

        station.accessibilityBlindnessInt?.let { levelId ->
            station.accessibilityLevelBlindness =
                accessibilityRepository.getBlindnessAccessibilityById(levelId = levelId)
        }

        station.accessibilityWheelchairInt?.let { levelId ->
            station.accessibilityLevelWheelchair =
                accessibilityRepository.getWheelchairAccessibilityById(levelId = levelId)
        }

        return station
    }

    override suspend fun fetchAdditionalStationData(stations: List<Station>): List<Station> =
        ArrayList<Station>().apply {
            stations.forEach { station ->
                add(fetchAdditionalStationData(station = station))
            }
        }

}
