package dev.yasan.metro.tehran.presentation.compose.preview.provider.station

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.domain.entity.station.Station
import dev.yasan.metro.tehran.presentation.compose.preview.PreviewDataHolder

/**
 * Provides preview parameters for [Station].
 */
class StationPreviewProvider : PreviewParameterProvider<Station> {

    override val values = PreviewDataHolder.lineSixStations
}
