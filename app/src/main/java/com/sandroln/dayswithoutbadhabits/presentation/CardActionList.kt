package com.sandroln.dayswithoutbadhabits.presentation.views

import com.sandroln.dayswithoutbadhabits.domain.Card

interface AddCardActions {
    fun addCard(position: Int)
}

interface MakeCardActions {
    fun cancelMakeCard(position: Int)
    fun saveNewCard(text: String, position: Int)
}

interface ZeroDaysCardActions {
    fun editZeroDaysCard(position: Int, card: Card.ZeroDays)
}

interface ZeroDaysEditActions : DeleteCard {
    fun cancelEditZeroDaysCard(position: Int, card: Card.ZeroDaysEdit)
    fun saveEditedZeroDaysCard(text: String, position: Int, id: Long)
}

interface NonZeroDaysCardActions {
    fun editNonZeroDaysCard(position: Int, card: Card.NonZeroDays)
}

interface NonZeroDaysEditCardActions : DeleteCard {
    fun resetNonZeroDaysCard(position: Int, card: Card.NonZeroDaysEdit)
    fun saveEditedNonZeroDaysCard(days: Int, text: String, position: Int, id: Long)
    fun cancelEditNonZeroDaysCard(position: Int, card: Card.NonZeroDaysEdit)
}

interface DeleteCard {
    fun deleteCard(position: Int, id: Long)
}