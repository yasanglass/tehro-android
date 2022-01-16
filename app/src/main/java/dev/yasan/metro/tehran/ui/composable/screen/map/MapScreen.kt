package dev.yasan.metro.tehran.ui.composable.screen.map

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.composable.common.teh.TehProgress
import dev.yasan.metro.tehran.ui.composable.common.teh.TehTitle
import dev.yasan.metro.tehran.ui.navigation.NavGraph
import dev.yasan.metro.tehran.ui.navigation.NavRoutes
import dev.yasan.metro.tehran.ui.theme.themePrimary

private const val TAG = "MapScreen"

/**
 * This screen shows the map.
 *
 * @see NavGraph
 * @see NavRoutes.routeMap
 */
@ExperimentalAnimationApi
@Composable
fun MapScreen(mapViewModel: MapViewModel) {

    val isLoaded = mapViewModel.isLoaded.observeAsState()

    class MapEventListener : SubsamplingScaleImageView.OnImageEventListener {

        override fun onReady() {
            Log.d(TAG, "onReady: ")
        }

        override fun onImageLoaded() {
            Log.d(TAG, "onImageLoaded: ")
            mapViewModel.setImageLoaded()
        }

        override fun onPreviewLoadError(e: Exception?) {
            Log.d(TAG, "onPreviewLoadError: ")
        }

        override fun onImageLoadError(e: Exception?) {
            Log.d(TAG, "onImageLoadError: ")
        }

        override fun onTileLoadError(e: Exception?) {
            Log.d(TAG, "onTileLoadError: ")
        }

        override fun onPreviewReleased() {
            Log.d(TAG, "onPreviewReleased: ")
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.layer_midground))
    ) {

        TehTitle(title = stringResource(id = R.string.map), colorBackground = themePrimary)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {

            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = {
                    SubsamplingScaleImageView(it).apply {
                        setImage(ImageSource.resource(R.drawable.map))
                    }
                },
                update = {
                    it.setOnImageEventListener(MapEventListener())
                }
            )

            androidx.compose.animation.AnimatedVisibility(visible = isLoaded.value != true) {
                TehProgress()
            }

        }
    }

}