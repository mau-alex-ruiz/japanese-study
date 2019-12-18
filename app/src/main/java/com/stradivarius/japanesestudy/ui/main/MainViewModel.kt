package com.stradivarius.japanesestudy.ui.main

import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal class MainViewModel(
    private val repository : LocalSessionWrapperImpl
) : ViewModel() {

    fun kanjiCardTitle() = R.string.kanji_card

    fun vocabCardTitle() = R.string.vocabulary_card

    fun radicalCardTitle() = R.string.radicals_card

}
