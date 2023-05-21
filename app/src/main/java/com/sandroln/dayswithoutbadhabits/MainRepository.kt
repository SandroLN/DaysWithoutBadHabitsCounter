package com.sandroln.dayswithoutbadhabits

interface MainRepository {

    fun reset()

    fun days(): Int
}