package com.sandroln.dayswithoutbadhabits

interface Now {

    fun time(): Long

    class Base() : Now {
        override fun time(): Long = System.currentTimeMillis()
    }
}