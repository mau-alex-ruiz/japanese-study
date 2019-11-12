package com.stradivarius.japanesestudy.ui.main

import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.ui.main.common.BaseViewModel

internal class MainViewModel : BaseViewModel() {

    val str: String = "If this appears, databinding worked."

    fun provideStr(): String = str

    override fun init() {

    }

}
