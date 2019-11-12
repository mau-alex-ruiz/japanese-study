package com.stradivarius.japanesestudy.ui.main.common.viewmodel

import androidx.lifecycle.ViewModel

internal interface ViewModelFactory {

    fun<I : ViewModel> createViewModel(clazz: Class<I>) : I

}