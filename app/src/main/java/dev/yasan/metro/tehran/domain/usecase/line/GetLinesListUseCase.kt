package dev.yasan.metro.tehran.domain.usecase.line

import dev.yasan.metro.tehran.domain.repository.line.LineRepository
import javax.inject.Inject

class GetLinesListUseCase @Inject constructor(
    private val lineRepository: LineRepository
) {

    suspend operator fun invoke() = lineRepository.getLines()
}
