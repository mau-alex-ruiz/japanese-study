package com.stradivarius.japanesestudy.ui.main.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

internal abstract class BaseToolbarFragment<V, B> : BaseFragment<V, B>()
    where V : BaseViewModel, B : ViewDataBinding {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setToolbarBackButtonEnabled(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun setToolbarBackButtonEnabled(enable: Boolean) {
        (activity as AppCompatActivity).supportActionBar.let {
            it?.setDisplayHomeAsUpEnabled(enable)
            it?.setDisplayShowHomeEnabled(enable)
        }
    }
}