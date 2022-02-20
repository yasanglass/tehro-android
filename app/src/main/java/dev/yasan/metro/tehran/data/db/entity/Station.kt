package dev.yasan.metro.tehran.data.db.entity

import androidx.compose.material.icons.sharp.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.*
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelWheelchair
import dev.yasan.metro.tehran.ui.theme.TehroIcons
import dev.yasan.metro.tehran.util.LocaleHelper
import dev.yasan.metro.tehran.util.PrideHelper
import kotlinx.parcelize.IgnoredOnParcel

/**
 * This class represents a station on [MetroDatabase].
 *
 * @see Line
 */
@Entity(
    tableName = "stations",
    foreignKeys = [
        ForeignKey(
            entity = Line::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("line_id"),
            onDelete = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = AccessibilityLevelWheelchair::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("accessibility_wheelchair_level"),
            onDelete = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = AccessibilityLevelBlindness::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("accessibility_blindness_level"),
            onDelete = ForeignKey.NO_ACTION
        )
    ]
)
data class Station(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name_fa") val nameFa: String,
    @ColumnInfo(name = "name_en") val nameEn: String,
    @ColumnInfo(name = "line_id", index = true) val lineId: Int,
    @ColumnInfo(name = "position_in_line") val positionInLine: Int,
    @ColumnInfo(name = "location_lat") val locationLatitude: Double?,
    @ColumnInfo(name = "location_long") val locationLongitude: Double?,
    @ColumnInfo(name = "map_x") val mapX: Int?,
    @ColumnInfo(name = "map_y") val mapY: Int?,
    @ColumnInfo(name = "has_emergency_medical_services") val hasEmergencyMedicalServices: Boolean,
    @ColumnInfo(
        name = "accessibility_wheelchair_level",
        index = true
    ) val accessibilityWheelchairInt: Int?,
    @ColumnInfo(
        name = "accessibility_blindness_level",
        index = true
    ) val accessibilityBlindnessInt: Int?,
) {

    /**
     * The proper name based on the device's default language.
     * @see nameFa
     * @see nameEn
     */
    val name: String get() = if (LocaleHelper.isFarsi) nameFa else nameEn

    @Ignore
    @IgnoredOnParcel
    var intersection: Intersection? = null

    @Ignore
    @IgnoredOnParcel
    var line: Line? = null

    @Ignore
    @IgnoredOnParcel
    var accessibilityLevelWheelchair: AccessibilityLevelWheelchair? = null

    @Ignore
    @IgnoredOnParcel
    var accessibilityLevelBlindness: AccessibilityLevelBlindness? = null

    /**
     * If the station has valid location data.
     */
    val hasLocation: Boolean get() = locationLatitude != null && locationLongitude != null

    /**
     * @return If the station is exactly the same station but in another line.
     */
    fun isVirtuallyTheSame(other: Station) = nameEn == other.nameEn

    /**
     * @return A custom icon based on the name of the station.
     */
    fun getIcon(): ImageVector? {
        return when {
            nameFa.contains("ورزشگاه") -> TehroIcons.Sports
            nameFa.contains("بیمه") -> TehroIcons.HealthAndSafety
            nameFa.contains("دانشگاه") -> TehroIcons.School
            nameFa.contains("آفتاب") -> TehroIcons.WbSunny
            nameFa.contains("دکتر") || nameFa.contains("سلامت") || nameFa.contains("هلال احمر") -> TehroIcons.LocalHospital
            nameFa.contains("بسیج") -> TehroIcons.MilitaryTech
            nameFa.contains("آهنگ") -> TehroIcons.Audiotrack
            nameFa.contains("ملت") || nameFa.contains("چهل تن") -> TehroIcons.Groups
            nameFa.contains("سرسبز") || nameFa.contains("ارم سبز") -> TehroIcons.Nature
            nameFa.contains("چیتگر") -> TehroIcons.Park
            nameFa.contains("ابن سینا") -> TehroIcons.Science
            nameFa.contains("دروازه") -> TehroIcons.DoorSliding
            nameFa.contains("خودرو") -> TehroIcons.CarRepair
            nameFa.contains("گرم‌دره") -> TehroIcons.Whatshot
            nameFa.contains("راه‌آهن") -> TehroIcons.Train
            nameFa.contains("گلشهر") -> TehroIcons.LocalFlorist
            nameFa.contains("رودکی") ||
                    nameFa.contains("مولوی") ||
                    nameFa.contains("فردوسی") ||
                    nameFa.contains("خیام") ||
                    nameFa.contains("سعدی") -> TehroIcons.HistoryEdu
            nameFa.contains("میدان") -> TehroIcons.TripOrigin
            nameFa.contains("فرودگاه") -> TehroIcons.LocalAirport
            nameFa.contains("خرداد") || nameFa.contains("هفتم تیر") -> TehroIcons.Event
            nameFa.contains("تئاتر") -> if (PrideHelper.isPrideMonth) TehroIcons.Looks else TehroIcons.TheaterComedy
            else -> null
        }
    }

}
