package com.sandroln.dayswithoutbadhabits.presentation.views

import android.content.Context
import android.text.Editable
import android.util.AttributeSet
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.sandroln.dayswithoutbadhabits.R
import com.sandroln.dayswithoutbadhabits.presentation.SimpleTextWatcher

class MakeCardView : AbstractCardView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        inflate(context, R.layout.make_card_view, this)

        val input = findViewById<TextInputEditText>(R.id.inputEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val cancelButton = findViewById<Button>(R.id.cancelButton)

        cancelButton.setOnClickListener {
            actions.cancelMakeCard(positionCallback.position(this))
        }
        saveButton.setOnClickListener {
            actions.saveNewCard(input.text.toString(), positionCallback.position(this))
        }

        input.addTextChangedListener(object : SimpleTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                val text = s.toString()
                saveButton.isEnabled = text.isNotEmpty()
            }
        })
    }
}