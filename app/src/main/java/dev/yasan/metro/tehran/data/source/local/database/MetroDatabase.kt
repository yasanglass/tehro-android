package dev.yasan.metro.tehran.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.yasan.metro.tehran.data.source.local.database.dao.AccessibilityLevelBlindnessDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.AccessibilityLevelWheelchairDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.DatabaseInformationDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.IntersectionDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.LineDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.StationDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.WcAvailabilityLevelDAO
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevelWheelchair
import dev.yasan.metro.tehran.domain.entity.accessibility.WcAvailabilityLevel
import dev.yasan.metro.tehran.domain.entity.dbinfo.DatabaseInformation
import dev.yasan.metro.tehran.domain.entity.intersection.Intersection
import dev.yasan.metro.tehran.domain.entity.line.Line
import dev.yasan.metro.tehran.domain.entity.station.Station
import javax.inject.Inject

@Database(
    entities = [
        Line::class,
        Station::class,
        Intersection::class,
        DatabaseInformation::class,
        AccessibilityLevelWheelchair::class,
        AccessibilityLevelBlindness::class,
        WcAvailabilityLevel::class
    ],
    version = 6,
)
abstract class MetroDatabase : RoomDatabase() {

    companion object {
        const val METRO_TEHRAN_DATABASE_NAME = "tehro"
        const val METRO_TEHRAN_DATABASE_FILE_NAME = "$METRO_TEHRAN_DATABASE_NAME.db"
    }

    abstract fun databaseInformationDAO(): DatabaseInformationDAO
    abstract fun interchangeDAO(): IntersectionDAO
    abstract fun lineDAO(): LineDAO
    abstract fun stationDAO(): StationDAO
    abstract fun accessibilityLevelBlindnessDAO(): AccessibilityLevelBlindnessDAO
    abstract fun accessibilityLevelWheelchairDAO(): AccessibilityLevelWheelchairDAO
    abstract fun wcAvailabilityLevelDAO(): WcAvailabilityLevelDAO

    class CallBack @Inject constructor() : RoomDatabase.Callback()
}
