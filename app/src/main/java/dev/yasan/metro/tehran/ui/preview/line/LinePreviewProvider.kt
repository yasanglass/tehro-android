package dev.yasan.metro.tehran.ui.preview.line

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.data.db.entity.Line
import dev.yasan.metro.tehran.util.PreviewHelper

/**
 * Provides preview parameters for [Line].
 */
class LinePreviewProvider : PreviewParameterProvider<Line> {

    override val values = PreviewHelper.lines

}