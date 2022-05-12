package dev.yasan.metro.tehran.data.repository.dbinfo

import dev.yasan.metro.tehran.data.source.local.database.dao.DatabaseInformationDAO
import dev.yasan.metro.tehran.domain.repository.dbinfo.DatabaseInformationRepository
import dev.yasan.metro.tehran.model.tehro.DatabaseInformation
import javax.inject.Inject

/**
 * The main implementation of [DatabaseInformationRepository].
 */
class DatabaseInformationRepositoryImp @Inject constructor(
    private val databaseInformationDAO: DatabaseInformationDAO
) : DatabaseInformationRepository {

    override suspend fun getInformation(): DatabaseInformation? {
        return databaseInformationDAO.get()
    }
}
