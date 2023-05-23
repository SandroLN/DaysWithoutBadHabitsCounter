package com.sandroln.dayswithoutbadhabits


interface MainRepository {

    fun reset()

    fun days(): Int

    class Base(
        private val cacheDataSource: CacheDataSource,
        private val now: Now
    ) : MainRepository {

        override fun reset() = cacheDataSource.save(now.time())

        override fun days(): Int {
            val saved = cacheDataSource.time(-1)
            return if (saved == -1L) {
                reset()
                0
            } else {
                val dif = now.time() - saved
                (dif / DAY_MILLIS).toInt()
            }
        }


        private companion object {
            private const val DAY_MILLIS = 24 * 3600 * 1000
        }
    }
}