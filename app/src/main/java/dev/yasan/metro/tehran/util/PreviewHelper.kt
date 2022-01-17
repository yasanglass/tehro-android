package dev.yasan.metro.tehran.util

import dev.yasan.metro.tehran.data.db.entity.*

/**
 * Provides dummy data to composable previews. All dummy variables for previews must be created here so they can be reused.
 *
 * The data here does not have to be kept up-to-date as these are only used for previews & do not affect the actual app content.
 */
object PreviewHelper {

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

    val lineSixStations = sequenceOf(
        Station(
            id = 28,
            nameEn = "Emam Hossein",
            nameFa = "امام حسین",
            lineId = 6,
            positionInLine = 0,
            interchangeId = 11
        ).apply {
            interchange = interchange11
        },
        Station(
            id = 29,
            nameEn = "Meydan-e Shohada",
            nameFa = "میدان شهدا",
            lineId = 6,
            positionInLine = 1,
            interchangeId = 7
        ).apply {
            interchange = interchange7
        },
        Station(
            id = 30,
            nameEn = "Besat",
            nameFa = "بعثت",
            lineId = 6,
            positionInLine = 2,
            interchangeId = null
        ),
        Station(
            id = 31,
            nameEn = "Dolat Abad",
            nameFa = "دولت\u200Cآباد",
            lineId = 6,
            positionInLine = 3,
            interchangeId = null
        )
    )

    private val interchange7 = Interchange(
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
            interchangeId = 7
        ).apply {
            line = lines.toList()[lineId - 1]
        }
        stationB = Station(
            id = 102,
            nameFa = "میدان شهدا",
            nameEn = "Meydan-e Shohada",
            positionInLine = 5,
            lineId = 4,
            interchangeId = 7
        ).apply {
            line = lines.toList()[lineId - 1]
        }
    }

    private val interchange11 = Interchange(
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
            interchangeId = 11
        ).apply {
            line = lines.toList()[lineId - 1]
        }
        stationB = Station(
            id = 57,
            nameFa = "امام حسین",
            nameEn = "Emam Hossein",
            positionInLine = 5,
            lineId = 2,
            interchangeId = 11
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
}
