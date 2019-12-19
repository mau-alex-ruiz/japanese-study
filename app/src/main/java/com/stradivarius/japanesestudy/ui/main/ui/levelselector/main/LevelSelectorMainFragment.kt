package com.stradivarius.japanesestudy.ui.main.ui.levelselector.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.databinding.LevelSelectorFragmentBinding
import com.stradivarius.japanesestudy.ui.main.MainFragment
import com.stradivarius.japanesestudy.ui.main.common.BaseToolbarFragment
import com.stradivarius.japanesestudy.ui.main.data.Levels
import java.lang.IllegalArgumentException

internal class LevelSelectorMainFragment(val cardType: Int)
    : BaseToolbarFragment<LevelSelectorViewModel, LevelSelectorFragmentBinding>() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewMainAdapter: RecyclerView.Adapter<LevelSelectorMainAdapter.MyViewHolder>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun provideViewModelClass() = LevelSelectorViewModel::class.java

    override fun provideLayoutResource(): Int = R.layout.level_selector_fragment

    override fun bindViewModel(viewModel: LevelSelectorViewModel, bindingLayout: LevelSelectorFragmentBinding) {
        viewModel.setCardCategory(cardType)
        bindingLayout.model = viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = super.onCreateView(inflater, container, savedInstanceState)
        setToolbarTitle()
        viewManager = LinearLayoutManager(context)
        viewMainAdapter = LevelSelectorMainAdapter(Levels.levelCategories, fragmentManager!!)
        recyclerView = rootView.findViewById<RecyclerView>(R.id.level_selector_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewMainAdapter
        }

        return rootView
    }

    private fun setToolbarTitle() {
        val title = when (cardType) {
            MainFragment.VOCAB_CARD -> R.string.vocabulary_card
            MainFragment.KANJI_CARD -> R.string.kanji_card
            MainFragment.RADICAL_CARD -> R.string.radicals_card
            else -> throw IllegalArgumentException("Incorrect card type.")
        }
        activity?.setTitle(title)
    }

    companion object {
        fun newInstance(cardType: Int) =
            LevelSelectorMainFragment(
                cardType
            )
    }
}