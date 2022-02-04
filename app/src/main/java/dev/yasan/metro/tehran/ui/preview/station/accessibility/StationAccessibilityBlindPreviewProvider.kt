package dev.yasan.metro.tehran.ui.preview.station.accessibility

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.data.db.entity.AccessibilityBlind
import dev.yasan.metro.tehran.data.db.entity.AccessibilityWheelchair

/**
 * Provides preview parameters for [AccessibilityBlind].
 */
class StationAccessibilityBlindPreviewProvider : PreviewParameterProvider<AccessibilityBlind> {

    override val values =
        sequenceOf(
            AccessibilityBlind.NONE,
            AccessibilityBlind.PLATFORMS_ONLY,
            AccessibilityBlind.FULL,
            AccessibilityBlind.INVALID
        )

}