package com.stradivarius.japanesestudy.ui.main.ui.lesson

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stradivarius.japanesestudy.R

class LessonAdapter(
    private val data: List<String>
) : RecyclerView.Adapter<LessonAdapter.MyViewHolder>() {

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.lesson_textview_layout, parent, false) as TextView

        return MyViewHolder(
            textView
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }



}