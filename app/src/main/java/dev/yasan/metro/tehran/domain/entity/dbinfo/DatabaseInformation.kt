package dev.yasan.metro.tehran.domain.entity.dbinfo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.yasan.metro.tehran.data.source.local.database.MetroDatabase
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import dev.yasan.metro.tehran.presentation.util.helper.extension.toPersianNumbers
import saman.zamani.persiandate.PersianDate

/**
 * This class contains a set of general data related to [MetroDatabase].
 */
@Entity(tableName = "information")
data class DatabaseInformation(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "last_modified_year") val lastModifiedYear: Int,
    @ColumnInfo(name = "last_modified_month") val lastModifiedMonth: Int,
    @ColumnInfo(name = "last_modified_day") val lastModifiedDay: Int,
) {

    /**
     * Converts all date variables into an easily readable [String].
     */
    fun getLastModifiedString(forceFarsi: Boolean = false): String {
        return if (LocaleHelper.isFarsi || forceFarsi) {
            val pDate = PersianDate().apply {
                grgDay = lastModifiedDay
                grgMonth = lastModifiedMonth
                grgYear = lastModifiedYear
            }
            "${pDate.shYear}/${pDate.shMonth}/${pDate.shDay}".toPersianNumbers()
        } else {
            "$lastModifiedYear-$lastModifiedMonth-$lastModifiedDay"
        }
    }
}
