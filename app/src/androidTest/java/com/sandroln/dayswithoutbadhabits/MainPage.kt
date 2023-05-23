package com.sandroln.dayswithoutbadhabits

import androidx.test.espresso.ViewInteraction


class MainPage : AbstractPage() {

    val mainText: ViewInteraction = R.id.mainTextView.view()
    val resetButton: ViewInteraction = R.id.resetButton.view()

}