package dev.yasan.metro.tehran.data.db.entity.accessibility

import androidx.room.*
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.data.db.entity.Station

/**
 * This class defines different wheelchair accessibility levels on [MetroDatabase].
 *
 * @see Station
 */
@Entity(tableName = "stations_accessibility_wheelchair_levels")
class AccessibilityLevelWheelchair(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") override val id: Int,
    @ColumnInfo(name = "description_en") override val descriptionEn: String,
    @ColumnInfo(name = "description_fa") override val descriptionFa: String,
): AccessibilityLevel(
    id = id,
    descriptionEn = descriptionEn,
    descriptionFa = descriptionFa
)


