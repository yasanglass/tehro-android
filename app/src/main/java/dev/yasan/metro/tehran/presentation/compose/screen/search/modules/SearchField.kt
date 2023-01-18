package dev.yasan.metro.tehran.presentation.compose.screen.search.modules

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.sharp.Clear
import androidx.compose.material.icons.sharp.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehDivider
import dev.yasan.metro.tehran.presentation.theme.TehroIcons
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onDone: () -> Unit,
) {
    val focusRequester = remember { FocusRequester() }

    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.layer_midground)
                )
                .fillMaxWidth()
                .padding(
                    start = grid(1.5f),
                    end = grid(1.5f),
                    top = grid(),
                    bottom = grid(2)
                )
                .focusRequester(focusRequester),
            value = value,
            onValueChange = {
                if (it.length <= 10) {
                    onValueChange(it)
                }
            },
            textStyle = TextStyle(
                fontFamily = rubikFamily,
                color = colorResource(id = R.color.text_title),
                fontSize = 18.sp
            ),
            label = {
                Text(
                    text = stringResource(id = R.string.line_name),
                    fontFamily = LocaleHelper.properFontFamily,
                    color = colorResource(id = R.color.text_title)
                )
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    TehroIcons.Search,
                    contentDescription = stringResource(id = R.string.search),
                    tint = colorResource(id = R.color.text_title),
                    modifier = Modifier
                        .clickable(onClick = onDone)
                        .padding(grid(2))
                )
            },
            keyboardOptions = KeyboardOptions(
                autoCorrect = true,
                capitalization = KeyboardCapitalization.Words,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onDone()
                }
            ),
            trailingIcon = {
                AnimatedVisibility(
                    visible = value.isNotEmpty(),
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Icon(
                        TehroIcons.Clear,
                        contentDescription = null,
                        tint = colorResource(id = R.color.text_title),
                        modifier = Modifier
                            .clickable {
                                onValueChange("")
                            }
                            .padding(grid(2))
                    )
                }
            },
            shape = RoundedCornerShape(0.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = colorResource(id = R.color.text_title),
                focusedBorderColor = colorResource(id = R.color.text_title),
                unfocusedBorderColor = colorResource(id = R.color.text_desc)
            )
        )

        TehDivider()
    }

    DisposableEffect(Unit) {
        focusRequester.requestFocus()
        onDispose { }
    }
}
