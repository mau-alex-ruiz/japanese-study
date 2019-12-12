package com.stradivarius.japanesestudy.ui.main.ui.levelselector

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.data.Levels
import kotlinx.android.synthetic.main.level_selector_dialog.view.*

class LevelSelectorDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dialog = inflater.inflate(R.layout.level_selector_dialog, container)
        dialog.level_category_text.text = Levels.levels[position!!].first
        return dialog
    }

    companion object {

        private var position: Int? = null
        fun newInstance(cardPosition: Int) : LevelSelectorDialog {
            position = cardPosition
            return LevelSelectorDialog()
        }
    }

}