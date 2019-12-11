package com.stradivarius.japanesestudy.ui.main

import android.util.Log
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.common.BaseViewModel
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal class MainViewModel(
    private val repository : LocalSessionWrapperImpl
) : BaseViewModel(repository) {

    fun kanjiCardTitle() = R.string.kanji_card

    fun vocabCardTitle() = R.string.vocabulary_card

    fun radicalCardTitle() = R.string.radicals_card

    override fun init() {
        Log.i("vm kanji list test", "${repository.database.value?.kanjiDao()?.getAll()}")
    }

}
