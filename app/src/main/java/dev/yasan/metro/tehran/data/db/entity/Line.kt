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
    @ColumnInfo(name = "is_branch", defaultValue = "0") val isBranchInt: Int
) {

    @Ignore
    @IgnoredOnParcel
    val isBranch = isBranchInt == 1

    val color: Color
        get() = if (!colorHex.isNullOrBlank())
            Color(android.graphics.Color.parseColor("#$colorHex")) else Color.DarkGray

    val name: String get() = if (LocaleHelper.isFarsi) nameFa else nameEn.uppercase()

}
