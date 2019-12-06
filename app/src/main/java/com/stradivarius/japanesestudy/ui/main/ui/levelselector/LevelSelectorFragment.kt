package com.stradivarius.japanesestudy.ui.main.ui.levelselector

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.databinding.LevelSelectorFragmentBinding
import com.stradivarius.japanesestudy.ui.main.common.BaseToolbarFragment
import com.stradivarius.japanesestudy.ui.main.data.Levels

internal class LevelSelectorFragment(cardType: Int)
    : BaseToolbarFragment<LevelSelectorViewModel, LevelSelectorFragmentBinding>() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<LevelSelectorAdapter.MyViewHolder>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun provideViewModelClass(): Class<LevelSelectorViewModel> = LevelSelectorViewModel::class.java

    override fun provideLayoutResource(): Int = R.layout.level_selector_fragment

    override fun bindViewModel(viewModel: LevelSelectorViewModel, bindingLayout: LevelSelectorFragmentBinding) {
        bindingLayout.model = viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = super.onCreateView(inflater, container, savedInstanceState)

        viewManager = LinearLayoutManager(context)
        viewAdapter = LevelSelectorAdapter(Levels.levels)

        recyclerView = rootView.findViewById<RecyclerView>(R.id.level_selector_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return rootView
    }

    companion object {
        fun newInstance(cardType: Int) =
            LevelSelectorFragment(cardType)
    }

}