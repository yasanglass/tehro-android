package dev.yasan.metro.tehran.util

import dev.yasan.metro.tehran.di.ApplicationModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * An interface meant for providing Coroutines' [Dispatchers] as Singletons using Hilt.
 *
 * @see Dispatchers
 * @see ApplicationModule
 */
interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}
