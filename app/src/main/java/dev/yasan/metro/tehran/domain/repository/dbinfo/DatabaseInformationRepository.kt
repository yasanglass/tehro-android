package dev.yasan.metro.tehran.domain.repository.dbinfo

import dev.yasan.metro.tehran.data.source.local.database.dao.DatabaseInformationDAO
import dev.yasan.metro.tehran.domain.entity.dbinfo.DatabaseInformation

/**
 * Handles all data related to [DatabaseInformation]s.
 */
interface DatabaseInformationRepository {

    /**
     * @return A [DatabaseInformation] if any exist.
     *
     * @see DatabaseInformationDAO
     */
    suspend fun getInformation(): DatabaseInformation?
}
