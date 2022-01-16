package dev.yasan.metro.tehran.util

import dev.yasan.metro.tehran.BuildConfig
import java.util.*

/**
 * Helper object for Pride related features.
 */
object PrideHelper {

    val homophobicBuildFlavor = BuildConfig.FLAVOR.contains("bazaar")

    val prideMode = !homophobicBuildFlavor && Calendar.getInstance()[Calendar.MONTH] == Calendar.FEBRUARY

}
