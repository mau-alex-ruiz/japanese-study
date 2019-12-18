package com.stradivarius.japanesestudy.ui.main.ui.levelselector.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.stradivarius.japanesestudy.R
import com.stradivarius.japanesestudy.ui.main.ui.levelselector.dialog.LevelSelectorDialog
import kotlinx.android.synthetic.main.level_selector_card.view.*

internal class LevelSelectorAdapter(
    private val data: List<Pair<String, List<Int>>>,
    private val fragmentManager: FragmentManager
) : RecyclerView.Adapter<LevelSelectorAdapter.MyViewHolder>() {

    class MyViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.level_selector_card, parent, false) as CardView

        return MyViewHolder(
            cardView
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val levelCategory = data[position].first
        holder.cardView.level_selector_text.text = levelCategory
        holder.cardView.setOnClickListener {
            val dialog = LevelSelectorDialog.newInstance(levelCategory)
            dialog.show(fragmentManager, "")
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}