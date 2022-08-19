package dev.yasan.metro.tehran.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import dagger.hilt.android.AndroidEntryPoint
import dev.yasan.metro.tehran.presentation.compose.TehroApp

/**
 * The main & only activity of Tehro.
 *
 * Adding unneeded code to it must be avoided. Anything that can be put inside [TehroApp] should not be put here.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(
        ExperimentalMaterialNavigationApi::class,
        ExperimentalAnimationApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TehroApp()
        }
    }
}

@Composable
fun mainActivity() = LocalContext.current as MainActivity
