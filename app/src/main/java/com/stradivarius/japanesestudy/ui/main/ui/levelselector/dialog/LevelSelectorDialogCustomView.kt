package com.stradivarius.japanesestudy.ui.main.ui.levelselector.dialog

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.stradivarius.japanesestudy.R

class LevelSelectorDialogCustomView : LinearLayout {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val view = View.inflate(context, R.layout.level_selector_dialog_custom_view, this)
        view.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }
}