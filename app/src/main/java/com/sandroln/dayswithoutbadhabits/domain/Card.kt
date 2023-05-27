package com.sandroln.dayswithoutbadhabits.domain

sealed class Card {

    object Add : Card()
    object Make : Card()

    data class ZeroDays(private val text: String, private val id: Long) : Card() {

        fun toEditable() = ZeroDaysEdit(text, id)
    }

    data class ZeroDaysEdit(private val text: String, private val id: Long) : Card() {
        fun toNonEditable() = ZeroDays(text, id)
    }

    data class NonZeroDays(private val days: Int, private val text: String, private val id: Long) :
        Card() {
        fun toEditable() = NonZeroDaysEdit(days, text, id)
    }

    data class NonZeroDaysEdit(
        private val days: Int,
        private val text: String,
        private val id: Long
    ) : Card() {

        fun reset(newMainInteractor: NewMainInteractor) = newMainInteractor.resetCard(id)

        fun toNonEditable() = NonZeroDays(days, text, id)

        fun toZeroDays() = ZeroDays(text, id)
    }
}
