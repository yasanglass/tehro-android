package dev.yasan.metro.tehran.presentation.compose.preview.provider.stat

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.domain.entity.stat.Stat

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
