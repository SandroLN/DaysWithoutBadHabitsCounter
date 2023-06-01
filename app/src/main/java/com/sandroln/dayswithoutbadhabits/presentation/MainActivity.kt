package com.sandroln.dayswithoutbadhabits.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sandroln.dayswithoutbadhabits.ProvideViewModel
import com.sandroln.dayswithoutbadhabits.R
import com.sandroln.dayswithoutbadhabits.presentation.views.CardsLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = (application as ProvideViewModel).provideMainViewModel()

        val makeUi = MakeUi.Base(this)
        val viewGroup = findViewById<CardsLayout>(R.id.customViewGroup)
        viewModel.observe(this) {
            it.apply(viewGroup, makeUi, viewModel)
        }
        viewModel.init(savedInstanceState == null)
    }
}