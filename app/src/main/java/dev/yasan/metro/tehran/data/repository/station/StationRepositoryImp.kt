package dev.yasan.metro.tehran.data.repository.station

import dev.yasan.metro.tehran.data.source.local.database.dao.StationDAO
import dev.yasan.metro.tehran.domain.entity.station.Station
import dev.yasan.metro.tehran.domain.repository.accessibility.AccessibilityRepository
import dev.yasan.metro.tehran.domain.repository.intersection.IntersectionRepository
import dev.yasan.metro.tehran.domain.repository.line.LineRepository
import dev.yasan.metro.tehran.domain.repository.station.StationRepository
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

    override suspend fun getStations(
        complete: Boolean,
        removeDuplicate: Boolean
    ): List<Station> {
        val stations: ArrayList<Station> = if (complete || removeDuplicate) {
            fetchAdditionalStationData(stations = stationDAO.getAll()) as ArrayList
        } else {
            stationDAO.getAll() as ArrayList
        }

        if (!removeDuplicate) return stations

        val distinctStations = ArrayList<Station>()

        stations.forEach { station ->
            if (distinctStations.none { it.nameEn == station.nameEn }) {
                distinctStations.add(station)
            }
        }

        return distinctStations
    }

    override suspend fun getStations(lineId: Int, complete: Boolean): List<Station> {
        val stations = stationDAO.getByLineId(lineId = lineId)
        return if (complete) {
            fetchAdditionalStationData(stations = stations)
        } else {
            stations
        }
    }

    override suspend fun getStation(stationId: Int, complete: Boolean): Station? {
        val station = stationDAO.getById(stationId = stationId)
        return if (station == null || !complete) {
            station
        } else {
            fetchAdditionalStationData(station = station)
        }
    }

    override suspend fun fetchAdditionalStationData(station: Station): Station {
        station.line = lineRepository.getLine(lineId = station.lineId)

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

        station.accessibilityBlindnessInt.let { levelId ->
            station.accessibilityLevelBlindness =
                accessibilityRepository.getBlindnessAccessibilityById(levelId = levelId)
        }

        station.accessibilityWheelchairInt.let { levelId ->
            station.accessibilityLevelWheelchair =
                accessibilityRepository.getWheelchairAccessibilityById(levelId = levelId)
        }

        station.wcInt.let { levelId ->
            station.wc =
                accessibilityRepository.getWcAvailabilityLevelById(levelId = levelId)
        }

        return station
    }

    override suspend fun fetchAdditionalStationData(stations: List<Station>): List<Station> =
        ArrayList<Station>().apply {
            stations.forEach { station ->
                add(fetchAdditionalStationData(station = station))
            }
        }

    override suspend fun searchStations(complete: Boolean, query: String): List<Station> {
        val stations = stationDAO.search(query = query)
        return if (complete) {
            fetchAdditionalStationData(stations = stations)
        } else {
            stations
        }
    }
}
