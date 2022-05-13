package dev.yasan.metro.tehran.presentation.util.helper.extension

import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper

/**
 * @see LocaleHelper.convertNumbersToPersian
 */
fun String.toPersianNumbers() = LocaleHelper.convertNumbersToPersian(this)

/**
 * @see LocaleHelper.convertNumbersToEnglish
 */
fun String.toEnglishNumbers() = LocaleHelper.convertNumbersToEnglish(this)
