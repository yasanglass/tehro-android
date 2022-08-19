package dev.yasan.metro.tehran.presentation.compose.preview.provider.line

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.domain.entity.line.Line
import dev.yasan.metro.tehran.presentation.compose.preview.PreviewDataHolder

/**
 * Provides preview parameters for [Line].
 */
class LinePreviewProvider : PreviewParameterProvider<Line> {

    override val values = PreviewDataHolder.lines
}
