package dev.yasan.metro.tehran.ui.preview.station.accessibility

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.data.db.entity.AccessibilityWheelchair
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.util.PreviewHelper

/**
 * Provides preview parameters for [AccessibilityWheelchair].
 */
class StationAccessibilityWheelchairPreviewProvider : PreviewParameterProvider<AccessibilityWheelchair> {

    override val values =
        sequenceOf(
            AccessibilityWheelchair.NONE,
            AccessibilityWheelchair.LEVEL_1,
            AccessibilityWheelchair.LEVEL_2,
            AccessibilityWheelchair.LEVEL_3,
            AccessibilityWheelchair.MAX,
            AccessibilityWheelchair.INVALID
    )

}