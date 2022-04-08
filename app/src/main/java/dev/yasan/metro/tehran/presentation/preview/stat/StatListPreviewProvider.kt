package dev.yasan.metro.tehran.presentation.preview.stat

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.model.tehro.Stat

/**
 * Provides preview parameters for [List]<[Stat]>.
 */
class StatListPreviewProvider : PreviewParameterProvider<List<Stat>> {

    override val values = sequenceOf(
        listOf(
            Stat(R.string.lines, 7),
            Stat(R.string.stations, 154),
            Stat(R.string.intersections, 75),
        )
    )

}
