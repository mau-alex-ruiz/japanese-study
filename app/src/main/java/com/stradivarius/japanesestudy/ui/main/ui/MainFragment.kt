package com.stradivarius.japanesestudy.ui.main.ui

import android.content.Context
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.databinding.MainFragmentBinding
import com.stradivarius.japanesestudy.ui.main.common.fragment.BaseFragment
import com.stradivarius.japanesestudy.ui.main.ui.levelselector.main.LevelSelectorMainFragment

internal class MainFragment(context: Context) : BaseFragment<MainViewModel, MainFragmentBinding>() {

    override fun provideViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun provideLayoutResource(): Int = R.layout.main_fragment

    override fun bindViewModel(viewModel: MainViewModel, bindingLayout: MainFragmentBinding) {
        bindingLayout.model = viewModel
        bindingLayout.vocabCard.cardView.setOnClickListener { startCardFragment(VOCAB_CARD) }
        bindingLayout.kanjiCard.cardView.setOnClickListener { startCardFragment(KANJI_CARD) }
        bindingLayout.radicalsCard.cardView.setOnClickListener { startCardFragment(RADICAL_CARD) }
    }

    private fun startCardFragment(cardType: Int) {
        showFragment(
            R.id.main_container,
            LevelSelectorMainFragment.newInstance(cardType),
            "LevelSelectorFragment"
        )
    }

    companion object {
        const val VOCAB_CARD = 1
        const val KANJI_CARD = 2
        const val RADICAL_CARD = 3

        fun newInstance(context: Context) =
            MainFragment(context)
    }
}
