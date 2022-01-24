package dev.yasan.metro.tehran.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * This class holds the location data for a [Station].
 *
 * @see Station
 */
@Entity(
    tableName = "station_locations",
    foreignKeys = [
        ForeignKey(
            entity = Line::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("line_id"),
            onDelete = ForeignKey.NO_ACTION
        )
    ]
)
data class StationLocation(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "line_id") val lineId: Int,
    @ColumnInfo(name = "latitude") val latitude: Double,
    @ColumnInfo(name = "longitude") val longitude: Double,
)
