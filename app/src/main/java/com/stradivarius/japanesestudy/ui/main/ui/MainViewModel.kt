package com.stradivarius.japanesestudy.ui.main.ui

import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.common.viewmodel.BaseViewModel
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal class MainViewModel(
    private val repository : LocalSessionWrapperImpl
) : BaseViewModel() {

    fun kanjiCardTitle() = R.string.kanji_card

    fun vocabCardTitle() = R.string.vocabulary_card

    fun radicalCardTitle() = R.string.radicals_card

    fun kanjiCardImage() = R.drawable.kanji_card_image

}
