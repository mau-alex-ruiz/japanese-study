package com.stradivarius.japanesestudy.ui.main.ui.levelselector

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.databinding.LevelSelectorDialogBinding
import com.stradivarius.japanesestudy.ui.main.data.Levels
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl


class LevelSelectorDialog : DialogFragment() {

    fun provideLayoutResource() = R.layout.level_selector_dialog

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
        bindingLayout.model = LevelSelectorViewModel(LocalSessionWrapperImpl)
        bindingLayout.setLifecycleOwner(this)
        return bindingLayout.root
    }

    companion object {

        private var position: Int? = null
        fun newInstance(cardPosition: Int) : LevelSelectorDialog {
            position = cardPosition
            return LevelSelectorDialog()
        }
    }

}