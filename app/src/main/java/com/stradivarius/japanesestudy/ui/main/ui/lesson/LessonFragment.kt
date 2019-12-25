package com.stradivarius.japanesestudy.ui.main.ui.lesson

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.databinding.LessonFragmentBinding
import com.stradivarius.japanesestudy.ui.main.common.fragment.BaseToolbarFragment

internal class LessonFragment(context: Context) : BaseToolbarFragment<LessonViewModel, LessonFragmentBinding>() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewMainAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun provideViewModelClass(): Class<LessonViewModel> = LessonViewModel::class.java

    override fun provideLayoutResource(): Int = R.layout.lesson_fragment

    override fun bindViewModel(viewModel: LessonViewModel, bindingLayout: LessonFragmentBinding) {
        bindingLayout.model = viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = super.onCreateView(inflater, container, savedInstanceState)
        viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewMainAdapter = LessonAdapter(viewmodel.getSymbolList(), viewmodel)
        recyclerView = rootView.findViewById<RecyclerView>(R.id.lesson_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewMainAdapter
        }
        val snapHelper = LessonSnapHelper(viewmodel)
        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    snapHelper.startView = snapHelper.findSnapView(viewManager)
                }
            }
        })
        snapHelper.attachToRecyclerView(recyclerView)

        return rootView
    }


    companion object {
        fun newInstance(context: Context) =
            LessonFragment(context)
    }
}