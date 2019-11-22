package com.stradivarius.japanesestudy.ui.main

import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.room.Room
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.databinding.MainFragmentBinding
import com.stradivarius.japanesestudy.ui.main.common.BaseFragment
import com.stradivarius.japanesestudy.ui.main.data.AppDataBase
import com.stradivarius.japanesestudy.ui.main.data.Kanji
import com.stradivarius.japanesestudy.ui.main.data.Radical
import com.stradivarius.japanesestudy.ui.main.data.Vocabulary
import java.io.File

internal class MainFragment(context: Context) : BaseFragment<MainViewModel, MainFragmentBinding>() {

    override fun provideViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun provideLayoutResource(): Int = R.layout.main_fragment

    override fun bindViewModel(viewModel: MainViewModel, bindingLayout: MainFragmentBinding) {
        bindingLayout.model = viewModel
        bindingLayout.kanjiCard.cardTitle.text = "Kanji"
    }

    companion object {
        fun newInstance(context: Context) =
            MainFragment(context)
    }
}
