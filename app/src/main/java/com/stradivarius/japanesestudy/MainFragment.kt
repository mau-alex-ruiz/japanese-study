package com.stradivarius.japanesestudy

import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.room.Room
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.stradivarius.japanesestudy.databinding.MainFragmentBinding
import com.stradivarius.japanesestudy.ui.main.common.BaseFragment
import com.stradivarius.japanesestudy.ui.main.data.AppDataBase
import com.stradivarius.japanesestudy.ui.main.data.Kanji

internal class MainFragment : BaseFragment<MainViewModel, MainFragmentBinding> {

    override fun provideViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun provideLayoutResource(): Int = R.layout.main_fragment

    override fun bindViewModel(viewModel: MainViewModel, bindingLayout: MainFragmentBinding) {
        bindingLayout.model = viewModel
    }

    constructor(context: Context) {

        val db = Room.databaseBuilder(
            context,
            AppDataBase::class.java, "kanji-database"
        ).allowMainThreadQueries().build()

        val mapper = jacksonObjectMapper()
        val objList: List<Kanji> = mapper.readValue(context.assets.open("kanji.json"))
        db.kanjiDao().insertAll(objList)
        val kanjiList : List<Kanji> = db.kanjiDao().getAll()
        Log.i("myApp", "$kanjiList")
        Log.i("myApp", "${Environment.getExternalStorageDirectory().absolutePath}")

    }

    companion object {
        fun newInstance(context: Context) = MainFragment(context)
    }

}
