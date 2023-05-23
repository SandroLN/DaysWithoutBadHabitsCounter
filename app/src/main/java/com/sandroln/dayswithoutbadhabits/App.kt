package com.sandroln.dayswithoutbadhabits

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData

class App : Application(), ProvideViewModel {

    private lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(
            MainRepository.Base(
                CacheDataSource.Base(
                    getSharedPreferences("base", Context.MODE_PRIVATE)
                ),
                Now.Base()
            ),
            MainCommunication.Base(MutableLiveData())
        )

    }

    override fun provideViewModel(): MainViewModel {
        return viewModel
    }
}

interface ProvideViewModel {

    fun provideViewModel(): MainViewModel
}