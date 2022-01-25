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
            entity = Station::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("station_id"),
            onDelete = ForeignKey.NO_ACTION
        )
    ]
)
data class StationLocation(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "station_id") val stationId: Int,
    @ColumnInfo(name = "latitude") val latitude: Double,
    @ColumnInfo(name = "longitude") val longitude: Double,
)
