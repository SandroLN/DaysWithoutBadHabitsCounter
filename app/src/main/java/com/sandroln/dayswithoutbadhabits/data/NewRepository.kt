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
        val cacheList = cacheDataSource.read()
        return cacheList.map { it.map(mapper) }
    }

    override fun newCard(text: String): Card {
        val id = now.time()
        val list = cacheDataSource.read()
        list.add(CardCache(id, id, text))
        cacheDataSource.save(list)
        return Card.ZeroDays(text, id)
    }

    override fun updateCard(id: Long, newText: String) {
        val mutableList = cacheDataSource.read()
        val card = mutableList.find { it.same(id) }!!
        val index = mutableList.indexOf(card)
        val newCard = card.updateText(newText)
        mutableList[index] = newCard
        cacheDataSource.save(mutableList)
    }

    override fun deleteCard(id: Long) {
        val cachedCards = cacheDataSource.read()
        val card = cachedCards.find { it.same(id) }!!
        cachedCards.remove(card)
        cacheDataSource.save(cachedCards)
    }

    override fun resetCard(id: Long) {
        val mutableList = cacheDataSource.read()
        val card = mutableList.find { it.same(id) }!!
        val index = mutableList.indexOf(card)
        val newCard = card.updateCountStartTime(now.time())
        mutableList[index] = newCard
        cacheDataSource.save(mutableList)
    }
}