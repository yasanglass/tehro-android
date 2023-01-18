package dev.yasan.metro.tehran.presentation.util.helper

import androidx.compose.ui.text.font.FontFamily
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import glass.yasan.kit.compose.type.rubikFamily
import java.util.*

/**
 * Helper object for locale related functionalities.
 */
object LocaleHelper {

    /**
     * If the default device language is Farsi/Persian.
     */
    val isFarsi get() = Locale.getDefault().language == "fa"

    /**
     * The proper font family based on the app language.
     *
     * @see isFarsi
     * @see vazirFamily
     * @see rubikFamily
     */
    val properFontFamily get(): FontFamily = if (isFarsi) vazirFamily else rubikFamily

    /**
     * Converts all the Persian numeric characters in the String into the English ones.
     * @param string Any string that contains English numeric characters
     */
    fun convertNumbersToEnglish(string: String): String = string
        .replace("۰", "0")
        .replace("۱", "1")
        .replace("۲", "2")
        .replace("٣", "3")
        .replace("٤", "4")
        .replace("۵", "5")
        .replace("٦", "6")
        .replace("٧", "7")
        .replace("۸", "8")
        .replace("۹", "9")

    /**
     * Converts all the English numeric characters in the String into the Persian ones.
     * @param string Any string that contains Persian numeric characters
     */
    fun convertNumbersToPersian(string: String): String = string
        .replace("0", "۰")
        .replace("1", "۱")
        .replace("2", "۲")
        .replace("3", "٣")
        .replace("4", "٤")
        .replace("5", "۵")
        .replace("6", "٦")
        .replace("7", "٧")
        .replace("8", "۸")
        .replace("9", "۹")
}
