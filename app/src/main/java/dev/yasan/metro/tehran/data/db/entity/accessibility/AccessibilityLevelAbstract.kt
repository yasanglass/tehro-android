package dev.yasan.metro.tehran.data.db.entity.accessibility

import dev.yasan.metro.tehran.util.LocaleHelper

abstract class AccessibilityLevel(
    open val id: Int,
    open val descriptionEn: String,
    open val descriptionFa: String,
) {

    /**
     * The proper description value based on the device's default language.
     * @see descriptionFa
     * @see descriptionEn
     */
    val description: String get() = if (LocaleHelper.isFarsi) descriptionFa else descriptionEn

}
