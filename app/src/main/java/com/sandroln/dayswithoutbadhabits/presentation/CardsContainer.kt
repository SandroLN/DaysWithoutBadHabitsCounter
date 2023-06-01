package com.sandroln.dayswithoutbadhabits.presentation

import com.sandroln.dayswithoutbadhabits.presentation.views.PositionCallback

interface CardsContainer<T : CardUi> : PositionCallback {

    fun add(index: Int, view: T)

    fun add(view: T)

    fun replace(index: Int, view: T)

    fun remove(index: Int)
}