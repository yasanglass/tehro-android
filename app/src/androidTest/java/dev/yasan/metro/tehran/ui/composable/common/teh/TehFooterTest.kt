package dev.yasan.metro.tehran.ui.composable.common.teh

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.yasan.metro.tehran.ui.main.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TehFooterTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val footerText = "Footer test text"
    private val spacerTestTag = "spacer"

    @Test
    fun footer_text_is_visible() {
        composeTestRule.setContent {
            TehFooter(text = footerText)
        }
        composeTestRule.onNodeWithText(footerText).assertIsDisplayed()
    }

    @Test
    fun footer_has_two_spacers_with_default_params() {
        composeTestRule.setContent {
            TehFooter(text = footerText)
        }
        composeTestRule.onAllNodesWithTag(spacerTestTag).assertCountEquals(2)
    }

    @Test
    fun footer_has_one_spacer_when_top_spacer_is_enabled_only() {
        composeTestRule.setContent {
            TehFooter(text = footerText, spacerTop = true, spacerBottom = false)
        }
        composeTestRule.onAllNodesWithTag(spacerTestTag).assertCountEquals(1)
    }

    @Test
    fun footer_has_one_spacer_when_bottom_spacer_is_enabled_only() {
        composeTestRule.setContent {
            TehFooter(text = footerText, spacerTop = false, spacerBottom = true)
        }
        composeTestRule.onAllNodesWithTag(spacerTestTag).assertCountEquals(1)
    }

    @Test
    fun footer_has_no_spacers_when_both_are_disabled() {
        composeTestRule.setContent {
            TehFooter(text = footerText, spacerTop = false, spacerBottom = false)
        }
        composeTestRule.onAllNodesWithTag("spacerTestTag").assertCountEquals(0)
    }

}