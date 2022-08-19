package dev.yasan.metro.tehran.presentation.compose.preview.provider.station

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.domain.entity.station.Station
import dev.yasan.metro.tehran.presentation.compose.preview.PreviewDataHolder

/**
 * Provides preview parameters for [List]<[Station]>.
 */
class StationListPreviewProvider : PreviewParameterProvider<List<Station>> {

    override val values = sequenceOf(PreviewDataHolder.lineSixStations.toList())
}
