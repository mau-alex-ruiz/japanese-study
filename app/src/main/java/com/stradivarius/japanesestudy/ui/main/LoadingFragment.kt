package com.stradivarius.japanesestudy.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl
import com.stradivarius.japanesestudy.ui.main.utils.AsyncDataBaseLoader

class LoadingFragment : Fragment() {

    fun provideLayoutResource(): Int = R.layout.progress_bar

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (LocalSessionWrapperImpl.database.value == null) {
            AsyncDataBaseLoader().execute(context)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(provideLayoutResource(), container, false)
    }

    companion object {
        fun newInstance() = LoadingFragment()
    }


}