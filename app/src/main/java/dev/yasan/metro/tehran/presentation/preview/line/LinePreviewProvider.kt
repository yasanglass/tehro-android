package dev.yasan.metro.tehran.presentation.preview.line

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.model.tehro.Line
import dev.yasan.metro.tehran.util.PreviewHelper

/**
 * Provides preview parameters for [Line].
 */
class LinePreviewProvider : PreviewParameterProvider<Line> {

    override val values = PreviewHelper.lines
}
