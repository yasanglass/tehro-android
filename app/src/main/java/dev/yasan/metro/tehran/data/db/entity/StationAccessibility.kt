package dev.yasan.metro.tehran.data.db.entity

import androidx.annotation.StringRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import dev.yasan.metro.tehran.R

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
    @ColumnInfo(name = "emergency_medical_services") val emergencyMedicalServicesInt: Int,
    @ColumnInfo(name = "wheelchair_accessibility_level") val wheelchairAccessibilityLevelInt: Int,
    @ColumnInfo(name = "blind_accessibility_level") val blindAccessibilityLevelInt: Int,
) {

    /**
     * If the station has emergency medical services.
     */
    val emergencyMedicalServices get() = emergencyMedicalServicesInt == 1

    val wheelchairAccessibilityLevel
        get() = AccessibilityWheelchair.fromInt(
            wheelchairAccessibilityLevelInt
        )

    val blindAccessibilityLevel get() = AccessibilityBlind.fromInt(blindAccessibilityLevelInt)

}

enum class AccessibilityWheelchair(@StringRes val stringResourceId: Int) {
    NONE(R.string.not_accessible),
    LEVEL_1(R.string.accessibility_wheelchair_level_1),
    LEVEL_2(R.string.accessibility_wheelchair_level_2),
    LEVEL_3(R.string.accessibility_wheelchair_level_3),
    MAX(R.string.accessibility_wheelchair_max),
    INVALID(R.string.failed_to_load_data);

    companion object {
        fun fromInt(value: Int) = values().getOrNull(value) ?: INVALID
    }

}

enum class AccessibilityBlind {
    NONE, PLATFORMS_ONLY, FULL, INVALID;

    companion object {
        fun fromInt(value: Int) =
            AccessibilityBlind.values().getOrNull(value) ?: AccessibilityBlind.INVALID
    }

}