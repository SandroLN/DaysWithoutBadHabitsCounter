package com.sandroln.dayswithoutbadhabits

import android.app.Application
import com.google.gson.Gson
import com.sandroln.dayswithoutbadhabits.data.NewCacheDataSource
import com.sandroln.dayswithoutbadhabits.data.NewRepository
import com.sandroln.dayswithoutbadhabits.domain.NewMainInteractor
import com.sandroln.dayswithoutbadhabits.presentation.MainCommunication
import com.sandroln.dayswithoutbadhabits.presentation.MainViewModel

class App : Application(), ProvideViewModel {

    private lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(
            MainCommunication.Base(),
            NewMainInteractor.Base(
                NewRepository(
                    NewCacheDataSource.Base(
                        SharedPref.Factory(BuildConfig.DEBUG).make(this),
                        Gson()
                    ),
                    Now.Base(),
                ),
                3
            ),
        )
    }

    override fun provideMainViewModel(): MainViewModel {
        return viewModel
    }
}

interface ProvideViewModel {

    fun provideMainViewModel(): MainViewModel
}