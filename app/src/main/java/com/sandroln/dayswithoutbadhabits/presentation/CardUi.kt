package com.sandroln.dayswithoutbadhabits.presentation

import com.sandroln.dayswithoutbadhabits.presentation.views.PositionCallback

interface CardUi{
    fun init(positionCallback: PositionCallback, actions: CardActions)
    fun clear()
}