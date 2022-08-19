package dev.yasan.metro.tehran.domain.usecase.line

import dev.yasan.metro.tehran.domain.repository.line.LineRepository
import javax.inject.Inject

class GetLineUseCase @Inject constructor(
    private val lineRepository: LineRepository
) {

    suspend operator fun invoke(lineId: Int) = lineRepository.getLine(lineId = lineId)
}
