package dev.yasan.metro.tehran.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import dagger.hilt.android.AndroidEntryPoint
import dev.yasan.metro.tehran.ui.composable.TehroApp

/**
 * The main & only activity of Tehro.
 *
 * Adding unneeded code to it must be avoided. Anything that can be put inside [TehroApp] should not be put here.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalMaterialNavigationApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TehroApp()
        }
    }
}
