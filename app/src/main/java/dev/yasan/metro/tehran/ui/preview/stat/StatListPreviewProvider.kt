package dev.yasan.metro.tehran.ui.preview.stat

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.Stat
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.util.PreviewHelper

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
