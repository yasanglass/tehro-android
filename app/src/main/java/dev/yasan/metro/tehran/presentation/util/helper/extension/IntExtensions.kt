package dev.yasan.metro.tehran.presentation.util.helper.extension

import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper

/**
 * @see LocaleHelper.convertNumbersToPersian
 */
fun Int.toStringPersian() = LocaleHelper.convertNumbersToPersian(this.toString())
