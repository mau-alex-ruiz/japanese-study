package com.stradivarius.japanesestudy.ui.main.ui.levelselector

import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.databinding.LevelSelectorFragmentBinding
import com.stradivarius.japanesestudy.ui.main.common.BaseToolbarFragment

internal class LevelSelectorFragment(cardType: Int) : BaseToolbarFragment<LevelSelectorViewModel, LevelSelectorFragmentBinding>() {

    override fun provideViewModelClass(): Class<LevelSelectorViewModel> = LevelSelectorViewModel::class.java

    override fun provideLayoutResource(): Int = R.layout.level_selector_fragment

    override fun bindViewModel(viewModel: LevelSelectorViewModel, bindingLayout: LevelSelectorFragmentBinding) {
        bindingLayout.model = viewModel
    }

    companion object {
        fun newInstance(cardType: Int) =
            LevelSelectorFragment(cardType)
    }

}