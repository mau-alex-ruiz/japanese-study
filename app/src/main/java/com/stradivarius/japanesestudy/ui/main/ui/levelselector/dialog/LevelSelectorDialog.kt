package com.stradivarius.japanesestudy.ui.main.ui.levelselector.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.databinding.LevelSelectorDialogBinding
import com.stradivarius.japanesestudy.ui.main.data.Levels
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl
import com.stradivarius.japanesestudy.ui.main.ui.levelselector.LevelSelectorViewModel

internal class LevelSelectorDialog : DialogFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<LevelSelectorDialogAdapter.MyViewHolder>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private fun provideLayoutResource() = R.layout.level_selector_dialog

    private lateinit var bindingLayout: LevelSelectorDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingLayout = DataBindingUtil.inflate(
            layoutInflater,
            provideLayoutResource(),
            container,
            false
        )
        setupAdapter()
        bindingLayout.model =
            LevelSelectorViewModel(
                LocalSessionWrapperImpl
            )
        bindingLayout.levelCategory.text = levelCategory
        bindingLayout.setLifecycleOwner(this)
        return bindingLayout.root
    }

    private fun setupAdapter() {
        viewManager = LinearLayoutManager(context)
        viewAdapter = LevelSelectorDialogAdapter(Levels.levels[levelCategory]!!)

        recyclerView = bindingLayout.root.findViewById<RecyclerView>(
            R.id.level_selector_dialog_recycler
        ).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    companion object {
        private var levelCategory: String? = null
        fun newInstance(levelCategory: String) : LevelSelectorDialog {
            this.levelCategory = levelCategory
            return LevelSelectorDialog()
        }
    }
}