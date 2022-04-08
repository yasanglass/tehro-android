package dev.yasan.metro.tehran.presentation.preview.station.accessibility

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.model.tehro.accessibility.AccessibilityLevel
import dev.yasan.metro.tehran.util.PreviewHelper

/**
 * Provides preview parameters for [AccessibilityLevel].
 */
class StationAccessibilityPreviewProvider : PreviewParameterProvider<AccessibilityLevel> {

    override val values = PreviewHelper.accessibilityLevels

}
