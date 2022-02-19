package dev.yasan.metro.tehran.data.db.entity

import androidx.room.*
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.util.LocaleHelper

/**
 * This class defines different wheelchair accessibility levels on [MetroDatabase].
 *
 * @see Station
 */
data class AccessibilityLevelWheelchair(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "description_en") val descriptionEn: String,
    @ColumnInfo(name = "description_fa") val descriptionFa: String,
) {

    /**
     * The proper description value based on the device's default language.
     * @see descriptionFa
     * @see descriptionEn
     */
    val description: String get() = if (LocaleHelper.isFarsi) descriptionFa else descriptionEn

}
