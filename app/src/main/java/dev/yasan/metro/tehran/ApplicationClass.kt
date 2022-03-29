package dev.yasan.metro.tehran

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.perf.FirebasePerformance
import dagger.hilt.android.HiltAndroidApp

/**
 * The application class of Tehro.
 */
@HiltAndroidApp
class ApplicationClass : Application() {

    override fun onCreate() {
        super.onCreate()

        // Disable Firebase on debug builds
        val firebaseEnabled = !BuildConfig.DEBUG
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(firebaseEnabled)
        FirebasePerformance.getInstance().isPerformanceCollectionEnabled = firebaseEnabled
        FirebaseAnalytics.getInstance(this).setAnalyticsCollectionEnabled(!firebaseEnabled)
    }


}
