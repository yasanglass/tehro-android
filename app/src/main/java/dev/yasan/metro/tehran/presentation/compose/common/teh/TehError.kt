package dev.yasan.metro.tehran.presentation.compose.common.teh

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.Close
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.theme.TehroIcons
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

/**
 * Different types/styles of errors that can be shown on [TehError].
 */
enum class TehErrorType {
    /**
     * This error type lets the user try again the previously failed action.
     * Must be used for errors that can potentially be solved by retrying.
     */
    ERROR_TRY_AGAIN,

    /**
     * This error type lets the user to go to the previous navigation route.
     * Must be used for errors that can never be solved by retrying.
     */
    ERROR_GO_BACK
}

/**
 * Tehro-themed error layout.
 * All errors should be presented using this composable.
 *
 * @param title The error's title text.
 * @param type The type of the error.
 *
 * @see TehErrorType
 */
@Composable
fun TehError(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.failed_to_load_data),
    type: TehErrorType = TehErrorType.ERROR_TRY_AGAIN,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    onClick: () -> Unit
) {
    val buttonText = when (type) {
        TehErrorType.ERROR_GO_BACK -> stringResource(id = R.string.back)
        TehErrorType.ERROR_TRY_AGAIN -> stringResource(id = R.string.try_again)
    }

    val buttonIcon = when (type) {
        TehErrorType.ERROR_GO_BACK -> TehroIcons.Close
        TehErrorType.ERROR_TRY_AGAIN -> TehroIcons.Refresh
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_midground))
            .padding(grid(2)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontFamily = fontFamily,
            color = colorResource(id = R.color.text_title),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.requiredHeight(grid(2)))

        TehButton(
            title = buttonText,
            icon = buttonIcon,
            onClick = {
                onClick()
            },
            fontFamily = fontFamily
        )
    }
}

@Preview(
    name = "Retry Error [en]",
    group = "Retry",
    locale = "en",
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
private fun TehErrorRetryPreviewEn() {
    TehError(
        fontFamily = rubikFamily,
        type = TehErrorType.ERROR_TRY_AGAIN,
        onClick = {}
    )
}

@Preview(
    name = "Retry Error [fa]",
    group = "Retry",
    locale = "fa",
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
private fun TehErrorRetryPreviewFa() {
    TehError(
        fontFamily = vazirFamily,
        type = TehErrorType.ERROR_TRY_AGAIN,
        onClick = {}
    )
}

@Preview(
    name = "Go Back Error [en]",
    group = "Go Back",
    locale = "en",
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
private fun TehErrorGoBackPreviewEn() {
    TehError(
        fontFamily = rubikFamily,
        type = TehErrorType.ERROR_GO_BACK,
        onClick = {}
    )
}

@Preview(
    name = "Go Back Error [fa]",
    group = "Go Back",
    locale = "fa",
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
private fun TehErrorGoBackPreviewFa() {
    TehError(
        fontFamily = vazirFamily,
        type = TehErrorType.ERROR_GO_BACK,
        onClick = {}
    )
}

@Preview(
    name = "Retry Error [en][night]",
    group = "Retry [night]",
    locale = "en",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun TehErrorRetryPreviewEnNight() {
    TehError(
        fontFamily = rubikFamily,
        type = TehErrorType.ERROR_TRY_AGAIN,
        onClick = {}
    )
}

@Preview(
    name = "Retry Error [fa][night]",
    group = "Retry [night]",
    locale = "fa",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun TehErrorRetryPreviewFaNight() {
    TehError(
        fontFamily = vazirFamily,
        type = TehErrorType.ERROR_TRY_AGAIN,
        onClick = {}
    )
}

@Preview(
    name = "Go Back Error [en][night]",
    group = "Go Back [night]",
    locale = "en",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun TehErrorGoBackPreviewEnNight() {
    TehError(
        fontFamily = rubikFamily,
        type = TehErrorType.ERROR_GO_BACK,
        onClick = {}
    )
}

@Preview(
    name = "Go Back Error [fa][night]",
    group = "Go Back [night]",
    locale = "fa",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun TehErrorGoBackPreviewFaNight() {
    TehError(
        fontFamily = vazirFamily,
        type = TehErrorType.ERROR_GO_BACK,
        onClick = {}
    )
}
