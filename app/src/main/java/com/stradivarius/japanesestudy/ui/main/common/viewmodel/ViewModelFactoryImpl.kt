package com.stradivarius.japanesestudy.ui.main.common.viewmodel

import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.ui.main.MainViewModel
import java.lang.IllegalArgumentException

internal class ViewModelFactoryImpl : ViewModelFactory {

    override fun <I : ViewModel> createViewModel(clazz: Class<I>) : I {
        @Suppress("UNCHECKED_CAST")
        return when (clazz) {
            MainViewModel::class.java -> MainViewModel()

            else -> throw IllegalArgumentException(
                "No class found for $clazz. See ${this::class.java}"
            )
        } as I
    }

}