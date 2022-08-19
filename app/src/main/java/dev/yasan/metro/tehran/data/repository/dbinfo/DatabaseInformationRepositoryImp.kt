package dev.yasan.metro.tehran.data.repository.dbinfo

import dev.yasan.metro.tehran.data.source.local.database.dao.DatabaseInformationDAO
import dev.yasan.metro.tehran.domain.entity.dbinfo.DatabaseInformation
import dev.yasan.metro.tehran.domain.repository.dbinfo.DatabaseInformationRepository
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
