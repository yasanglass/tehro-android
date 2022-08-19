package dev.yasan.metro.tehran.presentation.compose.preview

import androidx.compose.ui.graphics.Color
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevel
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevelWheelchair
import dev.yasan.metro.tehran.domain.entity.accessibility.WcAvailabilityLevel
import dev.yasan.metro.tehran.domain.entity.dbinfo.DatabaseInformation
import dev.yasan.metro.tehran.domain.entity.intersection.Intersection
import dev.yasan.metro.tehran.domain.entity.line.Line
import dev.yasan.metro.tehran.domain.entity.line.LineType
import dev.yasan.metro.tehran.domain.entity.station.Station

/**
 * Provides dummy data to composable previews. All dummy variables for previews must be created here so they can be reused.
 *
 * The data here does not have to be kept up-to-date as these are only used for previews & do not affect the actual app content.
 */
object PreviewDataHolder {

    val lines = sequenceOf(
        Line(
            id = 1,
            nameFa = "یک",
            nameEn = "One",
            colorHex = "C53642",
            typeInt = LineType.METRO_LINE.ordinal
        ),
        Line(
            id = 2,
            nameFa = "دو",
            nameEn = "Two",
            colorHex = "30577F",
            typeInt = LineType.METRO_LINE.ordinal
        ),
        Line(
            id = 3,
            nameFa = "سه",
            nameEn = "Three",
            colorHex = "59A7C2",
            typeInt = LineType.METRO_LINE.ordinal
        ),
        Line(
            id = 4,
            nameFa = "چهار",
            nameEn = "Four",
            colorHex = "E2C21D",
            typeInt = LineType.METRO_LINE.ordinal
        ),
        Line(
            id = 5,
            nameFa = "پنج",
            nameEn = "Five",
            colorHex = "1A796B",
            typeInt = LineType.METRO_LINE.ordinal
        ),
        Line(
            id = 6,
            nameFa = "شش",
            nameEn = "Six",
            colorHex = "F677AA",
            typeInt = LineType.METRO_LINE.ordinal
        ),
        Line(
            id = 7,
            nameFa = "هفت",
            nameEn = "Seven",
            colorHex = "7C4078",
            typeInt = LineType.METRO_LINE.ordinal
        ),
    )

    val lineColors get() = ArrayList<Color>().apply { lines.forEach { line -> add(line.color) } }

    val lineSixStations = sequenceOf(
        Station(
            id = 28,
            nameEn = "Emam Hossein",
            nameFa = "امام حسین",
            lineId = 6,
            positionInLine = 0,
            locationLatitude = null,
            locationLongitude = null,
            mapX = null,
            mapY = null,
            hasEmergencyMedicalServices = false,
            accessibilityBlindnessInt = 2,
            accessibilityWheelchairInt = 3,
            wcInt = 2
        ).apply {
            intersection = interchange11
        },
        Station(
            id = 29,
            nameEn = "Meydan-e Shohada",
            nameFa = "میدان شهدا",
            lineId = 6,
            positionInLine = 1,
            locationLatitude = null,
            locationLongitude = null,
            mapX = null,
            mapY = null,
            hasEmergencyMedicalServices = false,
            accessibilityBlindnessInt = 3,
            accessibilityWheelchairInt = 2,
            wcInt = 2
        ).apply {
            intersection = interchange7
        },
        Station(
            id = 30,
            nameEn = "Besat",
            nameFa = "بعثت",
            lineId = 6,
            positionInLine = 2,
            locationLatitude = null,
            locationLongitude = null,
            mapX = null,
            mapY = null,
            hasEmergencyMedicalServices = false,
            accessibilityBlindnessInt = 2,
            accessibilityWheelchairInt = 1,
            wcInt = 2
        ),
        Station(
            id = 31,
            nameEn = "Dolat Abad",
            nameFa = "دولت\u200Cآباد",
            lineId = 6,
            positionInLine = 3,
            locationLatitude = null,
            locationLongitude = null,
            mapX = null,
            mapY = null,
            hasEmergencyMedicalServices = false,
            accessibilityBlindnessInt = 3,
            accessibilityWheelchairInt = 2,
            wcInt = 2
        )
    )

    private val interchange7 = Intersection(
        id = 7,
        stationIdA = 29,
        stationIdB = 102
    ).apply {
        stationA = Station(
            id = 29,
            nameFa = "میدان شهدا",
            nameEn = "Meydan-e Shohada",
            positionInLine = 1,
            lineId = 6,
            locationLatitude = null,
            locationLongitude = null,
            mapX = null,
            mapY = null,
            hasEmergencyMedicalServices = false,
            accessibilityBlindnessInt = 2,
            accessibilityWheelchairInt = 3,
            wcInt = 2
        ).apply {
            line = lines.toList()[lineId - 1]
        }
        stationB = Station(
            id = 102,
            nameFa = "میدان شهدا",
            nameEn = "Meydan-e Shohada",
            positionInLine = 5,
            lineId = 4,
            locationLatitude = null,
            locationLongitude = null,
            mapX = null,
            mapY = null,
            hasEmergencyMedicalServices = false,
            accessibilityBlindnessInt = 2,
            accessibilityWheelchairInt = 3,
            wcInt = 2
        ).apply {
            line = lines.toList()[lineId - 1]
        }
    }

    private val interchange11 = Intersection(
        id = 7,
        stationIdA = 28,
        stationIdB = 57
    ).apply {
        stationA = Station(
            id = 28,
            nameFa = "امام حسین",
            nameEn = "Emam Hossein",
            positionInLine = 1,
            lineId = 6,
            locationLatitude = null,
            locationLongitude = null,
            mapX = null,
            mapY = null,
            hasEmergencyMedicalServices = false,
            accessibilityBlindnessInt = 2,
            accessibilityWheelchairInt = 3,
            wcInt = 2
        ).apply {
            line = lines.toList()[lineId - 1]
        }
        stationB = Station(
            id = 57,
            nameFa = "امام حسین",
            nameEn = "Emam Hossein",
            positionInLine = 5,
            lineId = 2,
            locationLatitude = null,
            locationLongitude = null,
            mapX = null,
            mapY = null,
            hasEmergencyMedicalServices = false,
            accessibilityBlindnessInt = 2,
            accessibilityWheelchairInt = 3,
            wcInt = 2
        ).apply {
            line = lines.toList()[lineId - 1]
        }
    }

    val databaseInformation = DatabaseInformation(
        id = 6,
        lastModifiedDay = 22,
        lastModifiedMonth = 2,
        lastModifiedYear = 2022
    )

    val accessibilityLevels = sequenceOf<AccessibilityLevel>(
        AccessibilityLevelBlindness(
            id = 1,
            descriptionEn = "Not accessible to the visually impaired",
            descriptionFa = "فاقد مسیر نابینایان",
        ),
        AccessibilityLevelBlindness(
            id = 2,
            descriptionEn = "Accessible to the visually impaired on platforms only",
            descriptionFa = "دارای مسیر نابینابان در سکو\u200Cها",
        ),
        AccessibilityLevelBlindness(
            id = 3,
            descriptionEn = "Accessible to the visually impaired",
            descriptionFa = "دارای مسیر نابینایان در تمام ایستگاه",
        ),
        AccessibilityLevelWheelchair(
            id = 1,
            descriptionEn = "Not accessible to the visually impaired",
            descriptionFa = "فاقد مسیر نابینایان",
        ),
        AccessibilityLevelWheelchair(
            id = 2,
            descriptionEn = "Accessible to the visually impaired on platforms only",
            descriptionFa = "دارای مسیر نابینابان در سکو\u200Cها",
        ),
        AccessibilityLevelWheelchair(
            id = 3,
            descriptionEn = "Accessible to the visually impaired",
            descriptionFa = "دارای مسیر نابینایان در تمام ایستگاه",
        ),
        WcAvailabilityLevel(
            id = 1,
            descriptionEn = "Rest room not available",
            descriptionFa = "فاقد سرویس بهداشتی",
        ),
        WcAvailabilityLevel(
            id = 2,
            descriptionEn = "Rest room available just outside the station",
            descriptionFa = "دارای سرویس بهداشتی در محوطه بیرونی ایستگاه",
        ),
        WcAvailabilityLevel(
            id = 3,
            descriptionEn = "Rest room available close to the station",
            descriptionFa = "دارای سرویس بهداشتی در کنار ایستگاه",
        ),
    )
}
