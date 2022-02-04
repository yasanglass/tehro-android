package dev.yasan.metro.tehran.ui.preview.station

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.util.PreviewHelper

/**
 * Provides preview parameters for [Station].
 */
class StationPreviewProvider : PreviewParameterProvider<Station> {

    override val values = PreviewHelper.lineSixStations
}
