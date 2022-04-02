package dev.yasan.metro.tehran.data.repo.dbinfo

import dev.yasan.metro.tehran.data.db.dao.DatabaseInformationDAO
import dev.yasan.metro.tehran.model.tehro.DatabaseInformation

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
