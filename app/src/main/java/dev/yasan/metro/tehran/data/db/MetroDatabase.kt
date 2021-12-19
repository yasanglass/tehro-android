package dev.yasan.metro.tehran.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.yasan.metro.tehran.data.db.dao.LineDAO
import dev.yasan.metro.tehran.data.db.entity.Line
import javax.inject.Inject

@Database(
    entities = [Line::class],
    version = 1,
)
abstract class MetroDatabase : RoomDatabase() {

    companion object {
        const val METRO_TEHRAN_DATABASE_NAME = "metro_database_tehran"
    }

    abstract fun lineDAO(): LineDAO

    class CallBack @Inject constructor() : RoomDatabase.Callback()

}