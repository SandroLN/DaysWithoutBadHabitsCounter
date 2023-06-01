package com.sandroln.dayswithoutbadhabits.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import com.sandroln.dayswithoutbadhabits.R
import com.sandroln.dayswithoutbadhabits.domain.Card

class NonZeroDaysCardView : AbstractCardView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setUp(days: String, text: String, card: Card.NonZeroDays) {
        inflate(context, R.layout.non_zero_days_card_view, this)
        findViewById<TextView>(R.id.daysTextView).text = days
        findViewById<TextView>(R.id.titleTextView).text = text
        findViewById<View>(R.id.editButton).setOnClickListener {
            actions.editNonZeroDaysCard(positionCallback.position(this), card)
        }
    }
}