package dev.yasan.metro.tehran.model.tehro

import dev.yasan.metro.tehran.util.LocaleHelper

/**
 * This class holds an [Any] statistic with its title.
 */
data class StatComplex(val titleEn: String, val titleFa: String, val value: Any? = null) {

    val title = if (LocaleHelper.isFarsi) titleFa else titleEn

}