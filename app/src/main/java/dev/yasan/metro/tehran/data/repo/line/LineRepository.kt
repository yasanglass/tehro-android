package dev.yasan.metro.tehran.data.repo.line

import dev.yasan.metro.tehran.data.db.entity.Line

interface LineRepository {

    suspend fun getLines(): List<Line>

}