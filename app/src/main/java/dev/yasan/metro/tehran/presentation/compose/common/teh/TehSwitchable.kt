package dev.yasan.metro.tehran.presentation.compose.common.teh

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import glass.yasan.kit.compose.foundation.grid

enum class TehSwitchableType {
    SWITCH, CHECKBOX
}

@Composable
fun TehSwitchable(
    title: String,
    type: TehSwitchableType = TehSwitchableType.SWITCH,
    fontFamily: FontFamily?,
    description: String? = null,
    icon: ImageVector? = null,
    getter: () -> Boolean,
    setter: (Boolean) -> Unit,
    enabled: Boolean = true,
    disabledReason: String? = null,
) {
    val context = LocalContext.current
    val checkedState: MutableState<Boolean> = remember { mutableStateOf(getter()) }

    Column {
        Row(
            modifier = Modifier
                .clickable {
                    if (enabled) {
                        checkedState.value = !checkedState.value
                        setter(checkedState.value)
                    } else if (!disabledReason.isNullOrBlank()) {
                        Toast
                            .makeText(context, disabledReason, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                .background(colorResource(id = R.color.layer_foreground))
                .padding(horizontal = grid(2)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = colorResource(id = R.color.text_title),
                    modifier = Modifier.padding(end = grid(2))
                )
            }
            Column(
                modifier = Modifier
                    .padding(end = grid())
                    .weight(1f)
                    .padding(vertical = grid(2))
            ) {
                Text(
                    text = title,
                    color = colorResource(id = if (enabled) R.color.text_title else R.color.text_desc),
                    fontFamily = fontFamily,
                    modifier = Modifier,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
                if (!description.isNullOrBlank()) {
                    Text(
                        text = description,
                        color = colorResource(id = R.color.text_desc),
                        modifier = Modifier,
                        fontSize = 12.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Light,
                    )
                }
            }

            when (type) {
                TehSwitchableType.CHECKBOX -> {
                    Checkbox(
                        checked = checkedState.value,
                        onCheckedChange = {
                            checkedState.value = it
                            setter(it)
                        },
                        enabled = enabled
                    )
                }
                TehSwitchableType.SWITCH -> {
                    Switch(
                        checked = checkedState.value,
                        onCheckedChange = {
                            checkedState.value = it
                            setter(it)
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = colorResource(id = R.color.text_title),
                            uncheckedThumbColor = colorResource(id = R.color.text_desc),
                            checkedTrackColor = colorResource(id = R.color.text_title),
                            uncheckedTrackColor = colorResource(id = R.color.text_desc),
                        ),
                        enabled = enabled
                    )
                }
            }
        }
        TehDivider()
    }
}
