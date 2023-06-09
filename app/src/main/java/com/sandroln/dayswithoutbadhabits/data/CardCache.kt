package com.sandroln.dayswithoutbadhabits.data

data class CardCache(
    private val id: Long,
    private val countStartTime: Long,
    private val text: String
) {

    fun <T> map(mapper: CardMapper<T>) = mapper.map(id, countStartTime, text)

    fun same(id: Long) = this.id == id

    fun updateText(newText: String): CardCache = CardCache(id, countStartTime, newText)

    fun updateCountStartTime(countStartTime: Long): CardCache = CardCache(id, countStartTime, text)
}