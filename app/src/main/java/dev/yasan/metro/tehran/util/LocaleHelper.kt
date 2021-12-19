package dev.yasan.metro.tehran.util

import java.util.*

object LocaleHelper {

    /**
     * Checks if the default device language is Farsi/Persian.
     */
    val isFarsi get() = Locale.getDefault().language == "fa"

}