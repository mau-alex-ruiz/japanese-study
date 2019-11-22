package com.stradivarius.japanesestudy.ui.main.common

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.common.viewmodel.ViewModelFactoryImpl
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl
import com.stradivarius.japanesestudy.ui.main.utils.AsyncDataBaseLoader

internal abstract class BaseFragment<V, B> : Fragment()
    where V : BaseViewModel, B: ViewDataBinding {

    protected abstract fun provideViewModelClass(): Class<V>

    protected abstract fun provideLayoutResource(): Int

    protected abstract fun bindViewModel(viewModel: V, bindingLayout: B)

    lateinit var viewModel: V

    private lateinit var bindingLayout: B

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelFactoryImpl(LocalSessionWrapperImpl).createViewModel(provideViewModelClass())

        viewModel.init()
        bindViewModel(viewModel, bindingLayout)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingLayout = DataBindingUtil.inflate<B>(
            layoutInflater,
            provideLayoutResource(),
            container,
            false
        )

        bindingLayout.setLifecycleOwner(this)
        return bindingLayout.root
    }

}