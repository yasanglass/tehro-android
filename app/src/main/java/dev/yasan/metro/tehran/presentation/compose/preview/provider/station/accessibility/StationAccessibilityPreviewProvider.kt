package dev.yasan.metro.tehran.presentation.compose.preview.provider.station.accessibility

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevel
import dev.yasan.metro.tehran.presentation.compose.preview.PreviewDataHolder

/**
 * Provides preview parameters for [AccessibilityLevel].
 */
class StationAccessibilityPreviewProvider : PreviewParameterProvider<AccessibilityLevel> {

    override val values = PreviewDataHolder.accessibilityLevels
}
