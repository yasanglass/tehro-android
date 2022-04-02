package dev.yasan.metro.tehran.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.yasan.metro.tehran.data.db.dao.*
import dev.yasan.metro.tehran.model.tehro.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.model.tehro.accessibility.AccessibilityLevelWheelchair
import dev.yasan.metro.tehran.model.tehro.accessibility.WcAvailabilityLevel
import dev.yasan.metro.tehran.model.tehro.DatabaseInformation
import dev.yasan.metro.tehran.model.tehro.Intersection
import dev.yasan.metro.tehran.model.tehro.Line
import dev.yasan.metro.tehran.model.tehro.Station
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

