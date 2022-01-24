package dev.yasan.metro.tehran.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.yasan.metro.tehran.data.db.dao.DatabaseInformationDAO
import dev.yasan.metro.tehran.data.db.dao.IntersectionDAO
import dev.yasan.metro.tehran.data.db.dao.LineDAO
import dev.yasan.metro.tehran.data.db.dao.StationDAO
import dev.yasan.metro.tehran.data.db.entity.DatabaseInformation
import dev.yasan.metro.tehran.data.db.entity.Intersection
import dev.yasan.metro.tehran.data.db.entity.Line
import dev.yasan.metro.tehran.data.db.entity.Station
import javax.inject.Inject

@Database(
    entities = [Line::class, Station::class, Intersection::class, DatabaseInformation::class],
    version = 2,
)
abstract class MetroDatabase : RoomDatabase() {

    companion object {
        const val METRO_TEHRAN_DATABASE_NAME = "tehro"
        const val METRO_TEHRAN_DATABASE_FILE_NAME = "tehro.db"
    }

    abstract fun databaseInformationDAO(): DatabaseInformationDAO
    abstract fun interchangeDAO(): IntersectionDAO
    abstract fun lineDAO(): LineDAO
    abstract fun stationDAO(): StationDAO

    class CallBack @Inject constructor() : RoomDatabase.Callback()
}
