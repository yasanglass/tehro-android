package dev.yasan.metro.tehran.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.yasan.metro.tehran.data.db.dao.*
import dev.yasan.metro.tehran.data.db.entity.*
import javax.inject.Inject

@Database(
    entities = [
        Line::class,
        Station::class,
        Intersection::class,
        DatabaseInformation::class,
        StationLocation::class,
        StationAccessibility::class
    ],
    version = 3,
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
    abstract fun stationLocationDAO(): StationLocationDAO
    abstract fun stationStationAccessibilityDAO(): StationAccessibilityDAO

    class CallBack @Inject constructor() : RoomDatabase.Callback()

}
