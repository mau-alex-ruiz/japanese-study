package com.stradivarius.japanesestudy.ui.main.ui.lesson

import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.ui.main.data.BaseDataTable
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl
import com.stradivarius.japanesestudy.ui.main.ui.MainFragment
import com.stradivarius.japanesestudy.ui.main.utils.AsyncImageLoader
import java.lang.IllegalArgumentException

internal class LessonViewModel(
    private val repository: LocalSessionWrapperImpl
) : ViewModel() {

    fun getSymbolList(): List<BaseDataTable> {
        val levels = repository.getCheckBoxMap().filter { it.value }.keys.toList()
        return when (repository.getCardCategory()) {
            MainFragment.VOCAB_CARD -> repository.database.vocabDao().getSelected(levels)
            MainFragment.KANJI_CARD -> repository.database.kanjiDao().getSelected(levels)
            MainFragment.RADICAL_CARD -> repository.database.radicalDao().getSelected(levels)
            else -> throw IllegalArgumentException("No such card category.")
        }
    }

}