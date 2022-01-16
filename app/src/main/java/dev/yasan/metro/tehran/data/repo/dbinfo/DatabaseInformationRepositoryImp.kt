package dev.yasan.metro.tehran.data.repo.dbinfo

import dev.yasan.metro.tehran.data.db.dao.DatabaseInformationDAO
import dev.yasan.metro.tehran.data.db.entity.DatabaseInformation
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
