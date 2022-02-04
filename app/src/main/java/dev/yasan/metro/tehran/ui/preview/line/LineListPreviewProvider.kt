package dev.yasan.metro.tehran.ui.preview.line

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.data.db.entity.Line
import dev.yasan.metro.tehran.util.PreviewHelper

/**
 * Provides preview parameters for [List]<[Line]>.
 */
class LineListPreviewProvider : PreviewParameterProvider<List<Line>> {

    override val values = sequenceOf(PreviewHelper.lines.toList())
}
