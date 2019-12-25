package com.stradivarius.japanesestudy.ui.main.ui.lesson

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.ui.main.common.viewmodel.BaseViewModel
import com.stradivarius.japanesestudy.ui.main.data.BaseDataTable
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl
import com.stradivarius.japanesestudy.ui.main.ui.MainFragment
import com.stradivarius.japanesestudy.ui.main.utils.AsyncImageLoader
import java.lang.IllegalArgumentException

internal class LessonViewModel(
    private val repository: LocalSessionWrapperImpl
) : BaseViewModel() {

    val nameText = MutableLiveData<String>()
    val readingText = MutableLiveData<String>()
    val levelText = MutableLiveData<String>()

    private val nextPosition = MutableLiveData<Int>()
    private lateinit var symbolList: List<BaseDataTable>

    private val nextPositionObserver: Observer<Int> = Observer {
        nameText.postValue(symbolList[it].nameEntry)
        readingText.postValue(symbolList[it].readingEntry)
        levelText.postValue(symbolList[it].levelEntry)
    }

    override fun init() {
        nextPosition.observeForever(nextPositionObserver)
        val levels = repository.getCheckBoxMap().filter { it.value }.keys.toList()
        symbolList = when (repository.getCardCategory()) {
            MainFragment.VOCAB_CARD -> repository.database.vocabDao().getSelected(levels)
            MainFragment.KANJI_CARD -> repository.database.kanjiDao().getSelected(levels)
            MainFragment.RADICAL_CARD -> repository.database.radicalDao().getSelected(levels)
            else -> throw IllegalArgumentException("No such card category.")
        }
        nameText.postValue(symbolList[0].nameEntry)
        readingText.postValue(symbolList[0].readingEntry)
        levelText.postValue(symbolList[0].levelEntry)
    }

    fun setNextPosition(position: Int) {
        nextPosition.postValue(position)
    }

    fun getSymbolList(): List<BaseDataTable> {
        return symbolList
    }

}