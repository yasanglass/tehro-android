package dev.yasan.metro.tehran.ui.composable.screen.station

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.yasan.metro.tehran.ui.theme.grid

@Composable
fun StationScreen(stationViewModel: StationViewModel, stationId: Int) {
    
    Text(text = stationId.toString(), modifier = Modifier.padding(grid(2)))

}