package com.stradivarius.japanesestudy.ui.main.common.viewmodel

import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.ui.main.ui.MainViewModel
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl
import com.stradivarius.japanesestudy.ui.main.ui.levelselector.main.LevelSelectorViewModel
import java.lang.IllegalArgumentException

internal class ViewModelFactoryImpl(
    private val repository: LocalSessionWrapperImpl
) : ViewModelFactory {

    override fun <I : ViewModel> createViewModel(clazz: Class<I>) : I {
        @Suppress("UNCHECKED_CAST")
        return when (clazz) {
            MainViewModel::class.java -> MainViewModel(
                repository
            )
            LevelSelectorViewModel::class.java -> LevelSelectorViewModel(repository)
            else -> throw IllegalArgumentException(
                "No class found for $clazz. See ${this::class.java}"
            )
        } as I
    }

}