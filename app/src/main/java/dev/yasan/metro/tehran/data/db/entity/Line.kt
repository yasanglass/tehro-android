package dev.yasan.metro.tehran.data.db.entity

import androidx.compose.ui.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import dev.yasan.metro.tehran.util.LocaleHelper
import kotlinx.parcelize.IgnoredOnParcel

@Entity(tableName = "lines")
data class Line(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name_fa") val nameFa: String,
    @ColumnInfo(name = "name_en") val nameEn: String,
    @ColumnInfo(name = "color") val colorHex: String?,
    @ColumnInfo(name = "type", defaultValue = "1") val typeInt: Int
) {

    companion object {
        private const val TAG = "Line"
    }

    @Ignore
    @IgnoredOnParcel
    val type = LineType.fromInt(typeInt)

    val color: Color
        get() = if (!colorHex.isNullOrBlank())
            Color(android.graphics.Color.parseColor("#$colorHex")) else Color.DarkGray

    val name: String get() = if (LocaleHelper.isFarsi) nameFa else nameEn.uppercase()

}
