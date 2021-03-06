package com.stradivarius.japanesestudy.ui.main.ui.levelselector.dialog

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stradivarius.japanesestudy.ui.main.repository.LocalSessionWrapperImpl
import com.stradivarius.japanesestudy.ui.main.ui.MainFragment
import kotlinx.android.synthetic.main.level_selector_dialog_custom_view.view.*
import java.lang.IllegalArgumentException

internal class LevelSelectorDialogAdapter(
    private val data: List<String>,
    private val viewmodel: LevelSelectorDialogViewModel
) : RecyclerView.Adapter<LevelSelectorDialogAdapter.MyViewHolder>() {

    class MyViewHolder(val view: LevelSelectorDialogCustomView) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val customView = LevelSelectorDialogCustomView(parent.context)

        return MyViewHolder(
            customView
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val level = data[position]

        holder.view.level_selector_checkbox.apply {
            text = level
            tag = level
            isChecked = LocalSessionWrapperImpl.getCheckBoxMap()[level] ?: false
            setOnCheckedChangeListener { buttonView, isChecked ->
                viewmodel.onCheckboxClick(buttonView, isChecked)
            }
        }

        holder.view.symbol_list_preview.apply {
            val repository = LocalSessionWrapperImpl
            val symbolList = when (repository.getCardCategory()) {
                MainFragment.VOCAB_CARD -> repository.database.vocabDao().getSelected(level)
                MainFragment.KANJI_CARD -> repository.database.kanjiDao().getSelected(level)
                MainFragment.RADICAL_CARD -> repository.database.radicalDao().getSelected(level)
                else -> throw IllegalArgumentException("No such card category.")
            }
            text = symbolList.mapNotNull { it.symbolEntry }.joinToString(", ")
                .ifEmpty {
                    holder.view.dialog_view.foreground = null
                    holder.view.level_selector_checkbox.isEnabled = false
                    "None"
                }
        }

        if (holder.view.level_selector_checkbox.isEnabled) {
            holder.view.setOnClickListener {
                holder.view.level_selector_checkbox.performClick()
            }
        }

}

    override fun getItemCount(): Int = data.size

}