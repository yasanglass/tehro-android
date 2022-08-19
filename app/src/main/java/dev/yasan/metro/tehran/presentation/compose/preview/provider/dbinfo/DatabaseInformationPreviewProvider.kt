package dev.yasan.metro.tehran.presentation.compose.preview.provider.dbinfo

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.domain.entity.dbinfo.DatabaseInformation
import dev.yasan.metro.tehran.presentation.compose.preview.PreviewDataHolder

/**
 * Provides preview parameters for [DatabaseInformation].
 */
class DatabaseInformationPreviewProvider : PreviewParameterProvider<DatabaseInformation?> {

    override val values = sequenceOf(PreviewDataHolder.databaseInformation, null)
}
