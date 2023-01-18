package dev.yasan.metro.tehran.domain.entity.accessibility

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.yasan.metro.tehran.data.source.local.database.MetroDatabase
import dev.yasan.metro.tehran.domain.entity.station.Station

/**
 * This class defines different visually impaired accessibility levels on [MetroDatabase].
 *
 * @see Station
 */
@Entity(tableName = "stations_accessibility_blindness_levels")
class AccessibilityLevelBlindness(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    override val id: Int,
    @ColumnInfo(name = "description_en") override val descriptionEn: String,
    @ColumnInfo(name = "description_fa") override val descriptionFa: String,
) : AccessibilityLevel(
    id = id,
    descriptionEn = descriptionEn,
    descriptionFa = descriptionFa,
    maxValue = 3
)
