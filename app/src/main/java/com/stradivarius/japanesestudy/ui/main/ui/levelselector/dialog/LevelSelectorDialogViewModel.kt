package com.stradivarius.japanesestudy.ui.main.ui.levelselector.dialog

import android.util.Log
import android.view.View
import com.stradivarius.japanesestudy.ui.main.common.BaseViewModel
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal class LevelSelectorDialogViewModel(
    private val repository : LocalSessionWrapperImpl
) : BaseViewModel(repository) {

    override fun init() {

    }

    fun onCheckboxClick(view: View) {
        Log.e("yeah", "jkfdsklfjds")
    }

    fun onSaveButtonClick(view: View) {
        Log.e("yeet", "klfjdslkfjd")
    }

}