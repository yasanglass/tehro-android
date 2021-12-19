package dev.yasan.metro.tehran.data.db.dao

import androidx.room.*
import dev.yasan.metro.tehran.data.db.entity.Line

/**
 * Data access object for [dev.yasan.metro.tehran.data.db.entity.Line].
 */
@Dao
interface LineDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(line: Line): Long

    @Query("SELECT * FROM lines ORDER BY id DESC")
    suspend fun get(): List<Line>

    @Query("SELECT * FROM lines WHERE id = :lineId")
    suspend fun get(lineId: Int): Line?

    @Query("DELETE FROM lines WHERE id = :lineId")
    suspend fun delete(lineId: Int)

    @Delete
    suspend fun delete(line: Line)

    @Query("DELETE FROM lines")
    suspend fun delete()

}
