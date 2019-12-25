package com.stradivarius.japanesestudy.ui.main.common.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

internal abstract class BaseViewModel : ViewModel() {

    open fun init() {
        Log.e("fds", "fds")
    }

}