package dev.yasan.metro.tehran.ui.preview.station.accessibility

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevel
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.util.PreviewHelper

/**
 * Provides preview parameters for [AccessibilityLevel].
 */
class StationAccessibilityPreviewProvider : PreviewParameterProvider<AccessibilityLevel> {

    override val values = PreviewHelper.accessibilityLevels

}
