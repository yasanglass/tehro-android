package dev.yasan.metro.tehran.presentation.util.entity

/**
 * Indicates the source of the launch.
 *
 * Used on some composables to customize the interface & behavior based on it as a better alternative to boolean parameters.
 */
enum class LaunchSource {
    INVALID,
    HOME,
    LINE,
    SEARCH,
    MAP;

    companion object {

        fun fromInt(int: Int) = LaunchSource.values().getOrNull(int) ?: INVALID
    }
}
