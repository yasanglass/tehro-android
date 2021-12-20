package dev.yasan.metro.tehran.data.db.entity

import android.util.Log

enum class LineType {
    METRO_LINE, METRO_BRANCH, INVALID;

    companion object {

        private const val TAG = "LineType"

        fun fromInt(value: Int): LineType {
            return try {
                values().first { it.ordinal + 1 == value }
            } catch (e: Exception) {
                Log.d(TAG, "fromInt: ${e.message}")
                INVALID
            }
        }
    }

}