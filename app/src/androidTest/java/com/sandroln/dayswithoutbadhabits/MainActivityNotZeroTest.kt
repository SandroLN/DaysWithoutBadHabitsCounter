package com.sandroln.dayswithoutbadhabits

import android.content.SharedPreferences
import org.junit.Test

class MainActivityNotZeroTest : AbstractUiTest() {

    override fun init(sharedPref: SharedPreferences) {
        CacheDataSource.Base(sharedPref).save(System.currentTimeMillis() - 17L * 24 * 3600 * 1000)
    }

    @Test
    fun test_zero_days_and_reset() {
        MainPage().run {
            mainText.check("17")
            resetButton.checkDisplayed()
            resetButton.click()
            mainText.check("0")
            resetButton.checkNotDisplayed()
        }
    }
}