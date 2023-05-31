package com.sandroln.dayswithoutbadhabits.data

import com.sandroln.dayswithoutbadhabits.Now
import com.sandroln.dayswithoutbadhabits.domain.Card

interface CardMapper<T> {

    fun map(
        id: Long,
        countStartTime: Long,
        text: String
    ): T

    class Base(private val now: Now) : CardMapper<Card> {

        override fun map(id: Long, countStartTime: Long, text: String): Card {
            val diff = now.time() - countStartTime
            val days = (diff / (24 * 3600 * 1000)).toInt()
            return if (days > 0)
                Card.NonZeroDays(days, text, id)
            else
                Card.ZeroDays(text, id)
        }
    }
}