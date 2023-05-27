package com.sandroln.dayswithoutbadhabits.domain

interface NewMainInteractor {

    fun cards(): List<Card>

    fun canAddNewCard(): Boolean

    fun newCard(text: String): Card

    fun deleteCard(id: Long)

    fun updateCard(id: Long, newText: String)

    fun resetCard(id: Long)
}