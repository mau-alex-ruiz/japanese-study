package com.stradivarius.japanesestudy.ui.main.ui.levelselector.dialog

import android.app.Dialog
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import androidx.core.widget.CompoundButtonCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal class LevelSelectorDialogViewModel(
    private val repository : LocalSessionWrapperImpl,
    private val dialog: Dialog
) : ViewModel() {

    val dialogTitle = MutableLiveData<String>()

    init {
        Log.e("test", "test")
    }

    fun onCheckboxClick(view: CompoundButton, isChecked: Boolean) {
        Log.e("tester", "${view.tag} and it is $isChecked}")
    }

    fun onSaveButtonClick(view: View) {
        Log.e("yeet", "${repository.cardCategory.value}")
        dialog.dismiss()
    }

}