package com.stradivarius.japanesestudy.ui.main.ui.lesson

import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal class LessonViewModel(
    private val repository: LocalSessionWrapperImpl
) : ViewModel() {

    fun showSymbol() : String {
        val list = repository.database.value?.vocabDao()?.getAll()

        return list?.get(0)?.symbol!!
    }


}