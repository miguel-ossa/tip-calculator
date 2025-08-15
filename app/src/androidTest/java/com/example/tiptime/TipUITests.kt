package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
import kotlin.text.format

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val billAmountLabel = context.getString(R.string.bill_amount)
        val tipPercentageLabel = context.getString(R.string.tip_percentage)

        val tipFormatString = context.getString(R.string.tip_amount)
        val expectedTip = NumberFormat.getCurrencyInstance().format(2 )
        val expectedTipLabelText = String.format(tipFormatString, expectedTip)

        composeTestRule.onNodeWithText(billAmountLabel).performTextInput("10")
        composeTestRule.onNodeWithText(tipPercentageLabel).performTextInput("20")
        composeTestRule.onNodeWithText(expectedTipLabelText).assertExists("No node with this text was found.")
    }
}