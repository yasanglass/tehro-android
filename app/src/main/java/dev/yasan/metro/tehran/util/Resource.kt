package dev.yasan.metro.tehran.util

import androidx.annotation.StringRes

/**
 * Used for handling data states.
 *
 * @param data The data you want to load/use.
 * @param messageResourceId The String resource id of the (error) message you want to show to the user.
 *
 * @property Initial Should be used as the default value of [Resource] variables. Can be used for initiating data load.
 * @property Loading Indicates that the data is being loaded.
 * @property Error Indicates data load failure. You should provide a [messageResourceId] for the user to see.
 * @property Success Indicates data load success. You can use the [data] variable as it should never be null in this state.
 */
sealed class Resource<T>(val data: T? = null, @StringRes val messageResourceId: Int? = null) {
    class Success<T>(data: T) : Resource<T>(data, null)
    class Error<T>(messageResourceId: Int) : Resource<T>(null, messageResourceId)
    class Loading<T> : Resource<T>()
    class Initial<T> : Resource<T>()
}
