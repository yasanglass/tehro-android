package dev.yasan.metro.tehran.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * This class holds the accessibility information about a [Station].
 *
 * @see Station
 */
@Entity(
    tableName = "stations_accessibility",
    foreignKeys = [
        ForeignKey(
            entity = Station::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("station_id"),
            onDelete = ForeignKey.NO_ACTION
        )
    ]
)
data class StationAccessibility(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "station_id") val stationId: Int,
    @ColumnInfo(name = "emergency_medical_services") val emergencyMedicalServices: Int,
    @ColumnInfo(name = "wheelchair_accessibility_level") val wheelchairAccessibilityLevel: Int,
    @ColumnInfo(name = "blind_accessibility_level") val blindAccessibilityLevel: Int,
)
