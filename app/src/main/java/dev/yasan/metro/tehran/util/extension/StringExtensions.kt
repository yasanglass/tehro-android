package dev.yasan.metro.tehran.util.extension

import dev.yasan.metro.tehran.util.LocaleHelper

/**
 * @see LocaleHelper.convertNumbersToPersian
 */
fun String.toPersianNumbers() = LocaleHelper.convertNumbersToPersian(this)

/**
 * @see LocaleHelper.convertNumbersToEnglish
 */
fun String.toEnglishNumbers() = LocaleHelper.convertNumbersToEnglish(this)
