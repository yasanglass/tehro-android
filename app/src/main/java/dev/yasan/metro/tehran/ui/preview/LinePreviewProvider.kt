package dev.yasan.metro.tehran.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.metro.tehran.data.db.entity.Line
import dev.yasan.metro.tehran.data.db.entity.LineType

class LinePreviewProvider : PreviewParameterProvider<Line> {

    override val values = sequenceOf(
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

}