package com.sandroln.dayswithoutbadhabits.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.sandroln.dayswithoutbadhabits.presentation.CardsContainer

class CardsLayout : LinearLayout, CardsContainer<AbstractCardView> {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun add(index: Int, view: AbstractCardView) = addView(view, index)

    override fun add(view: AbstractCardView) = addView(view)

    override fun replace(index: Int, view: AbstractCardView) {
        remove(index)
        add(index, view)
    }

    override fun remove(index: Int) {
        val child = getChildAt(index)
        (child as AbstractCardView).clear()
        removeView(child)
    }

    override fun position(cardUi: AbstractCardView) = indexOfChild(cardUi)
}