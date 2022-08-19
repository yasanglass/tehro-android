package dev.yasan.metro.tehran.domain.entity.stat

import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper

/**
 * This class holds an [Any] statistic with its title.
 */
data class StatComplex(val titleEn: String, val titleFa: String, val value: Any? = null) {

    val title = if (LocaleHelper.isFarsi) titleFa else titleEn
}
