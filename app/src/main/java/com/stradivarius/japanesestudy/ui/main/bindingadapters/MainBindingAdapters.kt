package com.stradivarius.japanesestudy.ui.main.bindingadapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.stradivarius.japanesestudy.ui.main.MainViewModel

@BindingAdapter("app:menuCardText")
internal fun menuCardText(textView: TextView, cardType: Int) {
    cardType.let {
        textView.text = textView.resources.getString(it)
    }
}