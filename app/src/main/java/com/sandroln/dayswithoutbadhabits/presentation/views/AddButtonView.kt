package com.sandroln.dayswithoutbadhabits.presentation.views

import android.content.Context
import android.util.AttributeSet
import com.sandroln.dayswithoutbadhabits.R

class AddButtonView : AbstractCardView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        inflate(context, R.layout.add_button_view, this)
        setOnClickListener {
            actions.addCard(positionCallback.position(this))
        }
    }
}