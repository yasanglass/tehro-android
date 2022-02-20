package dev.yasan.metro.tehran.data.db.entity

import androidx.compose.ui.graphics.Color
import androidx.room.*
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.util.LocaleHelper
import kotlinx.parcelize.IgnoredOnParcel

/**
 * This class represents a line on [MetroDatabase].
 * A line is simply a group of [Station]s.
 */
@Entity(tableName = "lines")
data class Line(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name_fa") val nameFa: String,
    @ColumnInfo(name = "name_en") val nameEn: String,
    @ColumnInfo(name = "color") val colorHex: String?,
    @ColumnInfo(name = "type", defaultValue = "1") val typeInt: Int
) {

    @Ignore
    @IgnoredOnParcel
    val type = LineType.fromInt(typeInt)

    val color: Color
        get() = if (!colorHex.isNullOrBlank())
            Color(android.graphics.Color.parseColor("#$colorHex")) else Color.DarkGray

    /**
     * The proper name based on the device's default language.
     * @see nameFa
     * @see nameEn
     */
    val name: String get() = if (LocaleHelper.isFarsi) nameFa else nameEn.uppercase()

}
