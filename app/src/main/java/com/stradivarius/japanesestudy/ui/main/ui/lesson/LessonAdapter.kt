package com.stradivarius.japanesestudy.ui.main.ui.lesson

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.recyclerview.widget.RecyclerView
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.data.BaseDataTable
import com.stradivarius.japanesestudy.ui.main.utils.AsyncImageLoader
import java.lang.IllegalArgumentException

internal class LessonAdapter(
    private val data: List<BaseDataTable>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class TextViewHolder(private val textView: TextView) : RecyclerView.ViewHolder(textView) {
        fun setText(text: String) {
            textView.text = text
        }
    }

    class ImageViewHolder(private val imageView: ImageView) : RecyclerView.ViewHolder(imageView) {

        fun loadImage(imageURL: String, holder: ImageViewHolder) {
            AsyncImageLoader(holder).execute(imageURL)
        }

        fun setImage(bitmap: Bitmap?) {
            bitmap?.let {
                imageView.setImageBitmap(bitmap)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TEXT_VIEW -> {
                val textView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.lesson_textview_layout, parent, false) as TextView
                TextViewHolder(textView)
            }
            IMAGE_VIEW -> {
                val imageView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.lesson_image_layout, parent, false) as ImageView
                ImageViewHolder(imageView)
            }
            else -> throw IllegalArgumentException("")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position].symbolEntry != null) TEXT_VIEW else IMAGE_VIEW
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dataObj = data[position]
        when(getItemViewType(position)) {
            TEXT_VIEW -> {
                (holder as TextViewHolder).setText(dataObj.symbolEntry!!)
            }
            IMAGE_VIEW -> {
                (holder as ImageViewHolder).loadImage(dataObj.symbolURLEntry!!, holder)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    companion object {
        const val TEXT_VIEW = 0
        const val IMAGE_VIEW = 1
    }

}