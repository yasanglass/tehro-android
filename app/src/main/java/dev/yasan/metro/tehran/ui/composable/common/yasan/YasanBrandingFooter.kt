package dev.yasan.metro.tehran.ui.composable.common.yasan

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.theme.grid

/**
 * YASAN branding footer composable. Must be used on the initial route of the app.
 *
 * @param spacerTop If the top spacer should be shown.
 * @param spacerBottom If the top bottom should be shown.
 */
@Composable
fun YasanBrandingFooter(
    spacerTop: Boolean = true,
    spacerBottom: Boolean = true,
) {

    val imageResource = R.drawable.ic_yasan_logo_text2_color

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (spacerTop) {
            Spacer(Modifier.requiredHeight(grid(8)))
        }
        Image(
            rememberImagePainter(
                data = imageResource,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = stringResource(id = R.string.yasan_logo),
            modifier = Modifier.requiredHeight(48.dp)
        )
        if (spacerBottom) {
            Spacer(Modifier.requiredHeight(grid(8)))
        }
    }
}
