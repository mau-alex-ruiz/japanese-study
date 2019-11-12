package com.stradivarius.japanesestudy.ui.main.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.MainViewModel
import com.stradivarius.japanesestudy.ui.main.common.viewmodel.ViewModelFactory
import com.stradivarius.japanesestudy.ui.main.common.viewmodel.ViewModelFactoryImpl

internal abstract class BaseFragment<V, B> : Fragment()
    where V : BaseViewModel, B: ViewDataBinding {

    protected abstract fun provideViewModelClass(): Class<V>

    protected abstract fun provideLayoutResource(): Int

    protected abstract fun bindViewModel(viewModel: V, bindingLayout: B)

    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: V

    protected lateinit var boundLayout: B


    @Suppress("UNCHECKED_CAST")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModelFactory = ViewModelFactoryImpl()

        viewModel = viewModelFactory.createViewModel(provideViewModelClass())

        viewModel.init()
        bindViewModel(viewModel, boundLayout)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        boundLayout = DataBindingUtil.inflate<B>(
            layoutInflater,
            provideLayoutResource(),
            container,
            false
        )
        boundLayout.setLifecycleOwner(this)
        return boundLayout.root
    }

}