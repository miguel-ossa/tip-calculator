package com.example.tiptime

import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundUp() {
        val amount = 10.0
        val tipPercent = 20.0
        val roundUp = false
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount, tipPercent, roundUp)
        assert(actualTip == expectedTip) { "Expected $expectedTip but got $actualTip" }
    }
}