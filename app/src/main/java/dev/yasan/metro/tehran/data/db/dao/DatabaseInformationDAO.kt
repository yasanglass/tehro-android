package dev.yasan.metro.tehran.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.model.tehro.DatabaseInformation

/**
 * Data access object for [DatabaseInformation].
 *
 * @see [MetroDatabase]
 */
@Dao
interface DatabaseInformationDAO {

    /**
     * @return one [DatabaseInformation] in [MetroDatabase]. It always returns only one
     * and it *should* never return null but luck favors the prepared.
     */
    @Query("SELECT * FROM information LIMIT 1")
    suspend fun get(): DatabaseInformation?
}
