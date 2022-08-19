package dev.yasan.metro.tehran.domain.usecase.stat

import dev.yasan.metro.tehran.domain.repository.stat.StatRepository
import javax.inject.Inject

class GetBasicStatisticsUseCase @Inject constructor(
    private val statRepository: StatRepository,
) {

    suspend operator fun invoke() = statRepository.getBasicStatistics()
}
