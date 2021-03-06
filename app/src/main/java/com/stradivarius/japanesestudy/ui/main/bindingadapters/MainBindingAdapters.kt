package com.stradivarius.japanesestudy.ui.main.bindingadapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:menuCardText")
internal fun menuCardText(textView: TextView, cardType: Int) {
    cardType.let {
        textView.text = textView.resources.getString(it)
    }
}

@BindingAdapter("app:menuCardImage")
internal fun menuCardImage(imageView: ImageView, imageResource: Int) {
    imageResource.let {
        imageView.setImageResource(it)
    }
}

@BindingAdapter("app:dialogTitleText")
internal fun dialogTitleText(textView: TextView, text: String?) {
    text?.let {
        textView.text = text
    }
}