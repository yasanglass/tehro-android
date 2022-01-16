package dev.yasan.metro.tehran.util.extension

import dev.yasan.metro.tehran.util.LocaleHelper

/**
 * @see LocaleHelper.convertNumbersToPersian
 */
fun Int.toStringPersian() = LocaleHelper.convertNumbersToPersian(this.toString())
