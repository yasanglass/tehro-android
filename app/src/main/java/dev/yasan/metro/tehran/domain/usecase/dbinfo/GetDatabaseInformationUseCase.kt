package dev.yasan.metro.tehran.domain.usecase.dbinfo

import dev.yasan.metro.tehran.domain.repository.dbinfo.DatabaseInformationRepository
import javax.inject.Inject

class GetDatabaseInformationUseCase @Inject constructor(
    private val databaseInformationRepository: DatabaseInformationRepository,
) {

    suspend operator fun invoke() = databaseInformationRepository.getInformation()
}
