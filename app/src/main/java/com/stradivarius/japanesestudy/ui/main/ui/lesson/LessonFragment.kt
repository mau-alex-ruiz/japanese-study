package com.stradivarius.japanesestudy.ui.main.ui.lesson

import android.content.Context
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.databinding.LessonFragmentBinding
import com.stradivarius.japanesestudy.ui.main.common.fragment.BaseToolbarFragment

internal class LessonFragment(context: Context) : BaseToolbarFragment<LessonViewModel, LessonFragmentBinding>() {

    override fun provideViewModelClass(): Class<LessonViewModel> = LessonViewModel::class.java

    override fun provideLayoutResource(): Int = R.layout.lesson_fragment

    override fun bindViewModel(viewModel: LessonViewModel, bindingLayout: LessonFragmentBinding) {
        bindingLayout.model = viewModel
    }


    companion object {

        fun newInstance(context: Context) =
            LessonFragment(context)
    }
}