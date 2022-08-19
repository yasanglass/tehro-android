package dev.yasan.metro.tehran.domain.entity.accessibility

import androidx.room.Ignore
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper

/**
 * Abstract class that handles basic accessibility level data.
 */
abstract class AccessibilityLevel(
    open val id: Int,
    open val descriptionEn: String,
    open val descriptionFa: String,
    @Ignore open val maxValue: Int
) {

    /**
     * Indicates the type/level of accessibility in three simple levels.
     * Used for visualising the accessibility level.
     */
    enum class Type {
        MIN,
        MIDDLE,
        MAX
    }

    /**
     * @return The object's [Type] based on its [id].
     */
    fun getType(): Type {
        return when (id) {
            1 -> {
                Type.MIN
            }
            maxValue -> {
                Type.MAX
            }
            else -> {
                Type.MIDDLE
            }
        }
    }

    /**
     * The proper description value based on the device's default language.
     * @see descriptionFa
     * @see descriptionEn
     */
    fun description(forceFarsi: Boolean = false): String =
        if (LocaleHelper.isFarsi || forceFarsi) descriptionFa else descriptionEn
}
