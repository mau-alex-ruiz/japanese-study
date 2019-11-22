package com.stradivarius.japanesestudy.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.stradivarius.japanesestudy.ui.main.common.BaseViewModel
import com.stradivarius.japanesestudy.ui.main.data.AppDataBase
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapper
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal class MainViewModel(
    private val repository : LocalSessionWrapperImpl
) : BaseViewModel(repository) {

    override fun init() {
        Log.i("vm kanji list test", "${repository.database.value?.kanjiDao()?.getAll()}")
    }

}
