package com.sandroln.dayswithoutbadhabits.data

import com.sandroln.dayswithoutbadhabits.Now
import com.sandroln.dayswithoutbadhabits.domain.Card
import com.sandroln.dayswithoutbadhabits.domain.Repository

class NewRepository(
    private val cacheDataSource: NewCacheDataSource,
    private val now: Now,
    private val mapper: CardMapper<Card> = CardMapper.Base(now)
) : Repository {

    override fun cards(): List<Card> {
        val cacheList = cacheDataSource.cards()
        return cacheList.map { it.map(mapper) }
    }

    override fun newCard(text: String): Card {
        val id = now.time()
        cacheDataSource.addCard(id, text)
        return Card.ZeroDays(text, id)
    }

    override fun updateCard(id: Long, newText: String) = cacheDataSource.updateCard(id, newText)


    override fun deleteCard(id: Long) = cacheDataSource.deleteCard(id)


    override fun resetCard(id: Long) = cacheDataSource.resetCard(id, now.time())

}