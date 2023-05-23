package com.sandroln.dayswithoutbadhabits

import android.app.Application
import androidx.lifecycle.MutableLiveData

class App : Application(), ProvideViewModel {

    private lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(
            MainRepository.Base(
                CacheDataSource.Base(SharedPref.Factory(BuildConfig.DEBUG).make(this)),
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