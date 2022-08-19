package dev.yasan.metro.tehran.presentation.util.helper

import android.content.Context
import dev.yasan.metro.tehran.BuildConfig
import dev.yasan.metro.tehran.R

/**
 * A simple helper class that helps with flavor related features.
 */
object FlavorHelper {

    fun getFlavorName(context: Context): String {
        return when {
            BuildConfig.FLAVOR.contains("play") -> {
                context.getString(R.string.play_store)
            }
            BuildConfig.FLAVOR.contains("bazaar") -> {
                context.getString(R.string.cafe_bazaar)
            }
            BuildConfig.FLAVOR.contains("github") -> {
                context.getString(R.string.github)
            }
            BuildConfig.FLAVOR.contains("fdroid") -> {
                context.getString(R.string.f_droid)
            }
            else -> context.getString(R.string.unknown)
        }
    }
}
