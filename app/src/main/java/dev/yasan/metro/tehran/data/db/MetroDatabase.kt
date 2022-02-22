package dev.yasan.metro.tehran.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.yasan.metro.tehran.data.db.dao.*
import dev.yasan.metro.tehran.data.db.entity.*
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelWheelchair
import javax.inject.Inject

@Database(
    entities = [
        Line::class,
        Station::class,
        Intersection::class,
        DatabaseInformation::class,
        AccessibilityLevelWheelchair::class,
        AccessibilityLevelBlindness::class
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

    class CallBack @Inject constructor() : RoomDatabase.Callback()

}

