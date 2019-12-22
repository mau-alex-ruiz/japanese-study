package com.stradivarius.japanesestudy.ui.main.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.common.viewmodel.ViewModelFactoryImpl
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl

internal abstract class BaseFragment<V, B> : Fragment()
    where V : ViewModel, B: ViewDataBinding {

    protected abstract fun provideViewModelClass(): Class<V>

    protected abstract fun provideLayoutResource(): Int

    protected abstract fun bindViewModel(viewModel: V, bindingLayout: B)

    private lateinit var viewModel: V

    private lateinit var bindingLayout: B

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelFactoryImpl(LocalSessionWrapperImpl).createViewModel(provideViewModelClass())

        bindViewModel(viewModel, bindingLayout)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingLayout = DataBindingUtil.inflate(
            layoutInflater,
            provideLayoutResource(),
            container,
            false
        )
        bindingLayout.lifecycleOwner = this
        return bindingLayout.root
    }

    fun showFragment(container: Int, fragment: Fragment, tag: String = "") {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(
                container,
                fragment,
                tag
            )?.addToBackStack("")?.commit()
    }

}