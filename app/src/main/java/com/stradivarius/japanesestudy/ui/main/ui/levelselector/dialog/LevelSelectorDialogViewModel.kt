package com.stradivarius.japanesestudy.ui.main.ui.levelselector.dialog

import android.app.Dialog
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal class LevelSelectorDialogViewModel(
    private val repository : LocalSessionWrapperImpl,
    private val dialog: Dialog
) : ViewModel() {

    init {
        Log.e("test", "test")
    }

    fun onCheckboxClick(view: View) {
        Log.e("yeah", "jkfdsklfjds")
    }

    fun onSaveButtonClick(view: View) {
        Log.e("yeet", "klfjdslkfjd")
        dialog.dismiss()
    }

}