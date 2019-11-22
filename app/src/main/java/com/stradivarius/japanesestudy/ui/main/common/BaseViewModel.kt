package com.stradivarius.japanesestudy.ui.main.common

import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapper

internal abstract class BaseViewModel(repository: LocalSessionWrapper) : ViewModel() {

   abstract fun init()

}