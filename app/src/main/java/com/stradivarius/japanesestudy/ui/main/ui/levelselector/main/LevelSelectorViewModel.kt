package com.stradivarius.japanesestudy.ui.main.ui.levelselector.main

import com.stradivarius.japanesestudy.ui.main.common.viewmodel.BaseViewModel
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal class LevelSelectorViewModel(
    private val repository : LocalSessionWrapperImpl
) : BaseViewModel() {

    fun setCardCategory(cardType: Int) {
        repository.setCardCategory(cardType)
    }

}