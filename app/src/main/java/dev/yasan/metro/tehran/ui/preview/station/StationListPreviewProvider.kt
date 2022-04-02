package dev.yasan.metro.tehran.ui.preview.station

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.model.tehro.Station
import dev.yasan.metro.tehran.util.PreviewHelper

/**
 * Provides preview parameters for [List]<[Station]>.
 */
class StationListPreviewProvider : PreviewParameterProvider<List<Station>> {

    override val values = sequenceOf(PreviewHelper.lineSixStations.toList())
}
