package com.stradivarius.japanesestudy.ui.main.ui.levelselector.dialog

import android.app.Dialog
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.ui.main.common.viewmodel.BaseViewModel
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal class LevelSelectorDialogViewModel(
    private val repository : LocalSessionWrapperImpl,
    private val dialog: Dialog
) : BaseViewModel() {

    val dialogTitle = MutableLiveData<String>()

    private val tempCheckBoxMap = mutableMapOf<String, Boolean>()

    fun onCheckboxClick(view: CompoundButton, isChecked: Boolean) {
        tempCheckBoxMap[view.tag.toString()] = isChecked
    }

    fun onCancelButtonClick(button: View) {
        dismissDialog(button)
    }

    fun onSaveButtonClick(button: View) {
        for ((key, value) in tempCheckBoxMap) {
            repository.getCheckBoxMap()[key] = value
        }
        dismissDialog(button)
    }

    fun dismissDialog(button: View) {
        button.postOnAnimationDelayed({
            dialog.dismiss()
        }, 150)
    }

}