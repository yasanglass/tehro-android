package dev.yasan.metro.tehran.domain.entity.stat

import androidx.annotation.StringRes

/**
 * This class holds a basic integer statistic with its title.
 */
data class Stat(@StringRes val titleStringResourceId: Int, val value: Int)
