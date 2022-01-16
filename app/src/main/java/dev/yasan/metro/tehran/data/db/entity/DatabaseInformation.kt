package dev.yasan.metro.tehran.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.yasan.metro.tehran.data.db.MetroDatabase

/**
 * This class contains a set of general data related to [MetroDatabase].
 */
@Entity(tableName = "information")
data class DatabaseInformation(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "last_modified_year") val lastModifiedYear: Int,
    @ColumnInfo(name = "last_modified_month") val lastModifiedMonth: Int,
    @ColumnInfo(name = "last_modified_day") val lastModifiedDay: Int,
)
