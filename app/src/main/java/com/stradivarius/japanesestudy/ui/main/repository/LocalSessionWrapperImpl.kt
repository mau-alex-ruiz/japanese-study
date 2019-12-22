package com.stradivarius.japanesestudy.ui.main.repository

import android.content.Context
import android.os.Environment
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.stradivarius.japanesestudy.ui.main.ui.MainFragment
import com.stradivarius.japanesestudy.ui.main.data.*
import java.io.File
import java.lang.IllegalArgumentException

internal object LocalSessionWrapperImpl : LocalSessionWrapper {

    private const val DATABASE_FILE = "japanese-study.db"

    private var cardCategory: Int = -1

    private val vocabCheckBoxMap = mutableMapOf<String, Boolean>()

    private val kanjiCheckBoxMap = mutableMapOf<String, Boolean>()

    private val radicalCheckBoxMap = mutableMapOf<String, Boolean>()

    val database = MutableLiveData<AppDataBase>()

    override fun init(context: Context?) {

        if (context != null) {

            val tempDatabase: AppDataBase

            val file = File(
                Environment.getDataDirectory().absolutePath +
                        "/data/com.stradivarius.japanesestudy/databases/" + DATABASE_FILE
            )

            if (file.exists()) {
                tempDatabase = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java, DATABASE_FILE
                ).createFromFile(file).allowMainThreadQueries().build()
            }
            else {
                tempDatabase = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java, DATABASE_FILE
                ).allowMainThreadQueries().build()

                val mapper = jacksonObjectMapper()

                tempDatabase.kanjiDao().insertAll(
                    mapper.readValue(context.assets.open("data-json/kanji.json"))
                )

                tempDatabase.radicalDao().insertAll(
                    mapper.readValue(context.assets.open("data-json/radicals.json"))
                )

                tempDatabase.vocabDao().insertAll(
                    mapper.readValue(context.assets.open("data-json/vocabulary.json"))
                )
            }
            database.postValue(tempDatabase)
        }
    }

    fun getCardCategory(): Int {
        return cardCategory
    }

    fun setCardCategory(cardType: Int) {
        cardCategory = cardType
    }

    override fun getCheckBoxMap(): MutableMap<String, Boolean> {
        return when(cardCategory) {
            MainFragment.VOCAB_CARD -> vocabCheckBoxMap
            MainFragment.KANJI_CARD -> kanjiCheckBoxMap
            MainFragment.RADICAL_CARD -> radicalCheckBoxMap
            else -> throw IllegalArgumentException("No such card type")
        }
    }
}