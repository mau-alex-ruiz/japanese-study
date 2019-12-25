package com.stradivarius.japanesestudy.ui.main.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.ui.main.common.viewmodel.BaseViewModel

internal abstract class BaseToolbarFragment<V, B> : BaseFragment<V, B>()
    where V : BaseViewModel, B : ViewDataBinding {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setToolbarBackButtonEnabled()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun setToolbarBackButtonEnabled() {
        (activity as AppCompatActivity).supportActionBar.let {
            it?.setDisplayHomeAsUpEnabled(true)
            it?.setDisplayShowHomeEnabled(true)
        }
    }
}