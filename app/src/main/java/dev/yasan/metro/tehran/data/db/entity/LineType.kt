package dev.yasan.metro.tehran.data.db.entity

import android.util.Log

enum class LineType {
    INVALID, METRO_LINE, METRO_BRANCH;

    companion object {

        private const val TAG = "LineType"

        fun fromInt(value: Int): LineType {
            return try {
                values().first { it.ordinal == value }
            } catch (e: NoSuchElementException) {
                Log.d(TAG, "fromInt: ${e.message}")
                INVALID
            }
        }
    }

}