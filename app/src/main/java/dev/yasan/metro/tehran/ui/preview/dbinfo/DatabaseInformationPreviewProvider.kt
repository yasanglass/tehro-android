package dev.yasan.metro.tehran.ui.preview.dbinfo

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.data.db.entity.DatabaseInformation
import dev.yasan.metro.tehran.util.PreviewHelper

/**
 * Provides preview parameters for [DatabaseInformation].
 */
class DatabaseInformationPreviewProvider : PreviewParameterProvider<DatabaseInformation> {

    override val values = sequenceOf(PreviewHelper.databaseInformation)

}