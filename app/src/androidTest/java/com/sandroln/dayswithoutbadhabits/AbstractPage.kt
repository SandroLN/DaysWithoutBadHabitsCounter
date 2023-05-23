package com.sandroln.dayswithoutbadhabits

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers

abstract class AbstractPage() {
    protected fun Int.view(): ViewInteraction = Espresso.onView(ViewMatchers.withId(this))
}