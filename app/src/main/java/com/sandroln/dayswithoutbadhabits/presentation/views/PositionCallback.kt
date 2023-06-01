package com.sandroln.dayswithoutbadhabits.presentation.views

interface PositionCallback {

    fun position(cardUi: AbstractCardView): Int

    class Empty : PositionCallback {
        override fun position(cardUi: AbstractCardView): Int = -1
    }
}