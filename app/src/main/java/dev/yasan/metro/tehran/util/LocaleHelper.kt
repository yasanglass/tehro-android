package dev.yasan.metro.tehran.util

import androidx.compose.ui.text.font.FontFamily
import dev.yasan.metro.tehran.ui.theme.rubikFamily
import dev.yasan.metro.tehran.ui.theme.vazirFamily
import java.util.*

object LocaleHelper {

    /**
     * Checks if the default device language is Farsi/Persian.
     */
    val isFarsi get() = Locale.getDefault().language == "fa"

    /**
     * Returns the proper font family based on the app language.
     */
    val properFontFamily get(): FontFamily = if (isFarsi) vazirFamily else rubikFamily

}