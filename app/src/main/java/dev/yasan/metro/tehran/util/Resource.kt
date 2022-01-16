package dev.yasan.metro.tehran.util

import androidx.annotation.StringRes

/**
 * Used for handling data states.
 *
 * @param data The data you want to load/use.
 * @param messageResourceId The String resource id of the (error) message you want to show to the user.
 */
sealed class Resource<T>(val data: T? = null, @StringRes val messageResourceId: Int? = null) {
    /**
     * Indicates data load success. You can use the [data] variable as it should never be null in this state.
     */
    class Success<T>(data: T) : Resource<T>(data, null)

    /**
     * Indicates data load failure. You should provide a [messageResourceId] for the user to see.
     */
    class Error<T>(messageResourceId: Int) : Resource<T>(null, messageResourceId)

    /**
     * Indicates that the data is being loaded.
     */
    class Loading<T> : Resource<T>()

    /**
     * Should be used as the default value of [Resource] variables. Can be used for initiating data load.
     */
    class Initial<T> : Resource<T>()
}
