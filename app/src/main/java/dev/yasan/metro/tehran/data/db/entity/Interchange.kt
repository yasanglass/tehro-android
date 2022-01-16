package dev.yasan.metro.tehran.data.db.entity

import androidx.room.*
import dev.yasan.metro.tehran.data.db.MetroDatabase
import kotlinx.parcelize.IgnoredOnParcel

/**
 * This class represents an interchange on [MetroDatabase].
 * An interchange represents a place where two [Line]s cross each other & passengers can change the [Line] they are on.
 */
@Entity(
    tableName = "interchanges",
    foreignKeys = [
        ForeignKey(
            entity = Station::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("station_a"),
            onDelete = ForeignKey.NO_ACTION
        ), ForeignKey(
            entity = Station::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("station_b"),
            onDelete = ForeignKey.NO_ACTION
        )
    ],
)
data class Interchange(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "station_a", index = true) val stationIdA: Int,
    @ColumnInfo(name = "station_b", index = true) val stationIdB: Int,
) {

    @Ignore
    @IgnoredOnParcel
    var stationA: Station? = null

    @Ignore
    @IgnoredOnParcel
    var stationB: Station? = null

    /**
     * @return If interchange's [stationA] & [stationB] are both not null.
     */
    fun hasBothStations() = stationA != null && stationB != null

    /**
     * @return The opposite line of the interchange based on the received [stationId].
     *
     * @see stationA
     * @see stationB
     */
    fun getOppositeLine(stationId: Int): Line? {
        return if (stationId == stationIdA) stationB?.line
        else stationA?.line
    }
}
