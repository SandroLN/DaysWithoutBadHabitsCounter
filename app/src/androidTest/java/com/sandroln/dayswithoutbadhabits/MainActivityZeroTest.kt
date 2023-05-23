package com.sandroln.dayswithoutbadhabits

import android.content.SharedPreferences
import org.junit.Test

class MainActivityZeroTest : AbstractUiTest() {

    override fun init(sharedPref: SharedPreferences) {
        sharedPref.edit().clear().apply()
    }

    @Test
    fun test_zero_days_and_reset() {
        MainPage().run {
            mainText.check("0")
            resetButton.checkNotDisplayed()
        }
    }


}