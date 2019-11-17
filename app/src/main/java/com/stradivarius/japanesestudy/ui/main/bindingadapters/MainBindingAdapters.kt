package com.stradivarius.japanesestudy.ui.main.bindingadapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("bind:changeMainText")
fun changeMainText(textView: TextView, text: String?) {
    text?.also {
        textView.text =  text
    }
}