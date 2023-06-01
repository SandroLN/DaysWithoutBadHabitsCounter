package com.sandroln.dayswithoutbadhabits.presentation.views

import android.content.Context
import android.text.Editable
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.sandroln.dayswithoutbadhabits.R
import com.sandroln.dayswithoutbadhabits.domain.Card
import com.sandroln.dayswithoutbadhabits.presentation.SimpleTextWatcher

class ZeroDaysEditCardView : AbstractCardView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var deletePressed = false

    fun setUp(id: Long, text: String, card: Card.ZeroDaysEdit) {
        inflate(context, R.layout.zero_days_edit_card_view, this)
        val deleteButton = findViewById<Button>(R.id.deleteButton)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val cancelButton = findViewById<Button>(R.id.cancelButton)
        val input = findViewById<TextInputEditText>(R.id.inputEditText)

        input.setText(text)
        input.addTextChangedListener(object : SimpleTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                saveButton.isEnabled = text != s.toString()
            }
        })

        deleteButton.setOnClickListener {
            if (deletePressed)
                actions.deleteCard(positionCallback.position(this), id)
            else {
                saveButton.visibility = View.GONE
                deleteButton.setText(R.string.confirm_delete_card)
                deletePressed = true
            }
        }

        saveButton.setOnClickListener {
            actions.saveEditedZeroDaysCard(
                input.text.toString(),
                positionCallback.position(this),
                id
            )
        }

        cancelButton.setOnClickListener {
            if (deletePressed) {
                deletePressed = false
                deleteButton.setText(R.string.delete_card)
                saveButton.visibility = View.VISIBLE
            } else
                actions.cancelEditZeroDaysCard(positionCallback.position(this), card)
        }
    }
}