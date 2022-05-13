package dev.yasan.metro.tehran.presentation.compose.screen.about.modules

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.compose.screen.about.AboutScreen

/**
 * Holds icons used on [AboutScreen] which are not a part of the Material icons library.
 */
object AboutIcons {

    /**
     * @return Discord icon as a [Painter].
     */
    @Composable
    fun discordIcon(): Painter = painterResource(id = R.drawable.ic_discord)

    /**
     * @return Instagram icon as a [Painter].
     */
    @Composable
    fun instagramIcon(): Painter = painterResource(id = R.drawable.ic_instagram)

    /**
     * @return Telegram icon as a [Painter].
     */
    @Composable
    fun telegramIcon(): Painter = painterResource(id = R.drawable.ic_telegram)

    /**
     * @return Twitter icon as a [Painter].
     */
    @Composable
    fun twitterIcon(): Painter = painterResource(id = R.drawable.ic_twitter)

    /**
     * @return Medium icon as a [Painter].
     */
    @Composable
    fun mediumIcon(): Painter = painterResource(id = R.drawable.ic_medium)
}
