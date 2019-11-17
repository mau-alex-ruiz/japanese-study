package com.stradivarius.japanesestudy.ui.main.data

import android.content.Context
import androidx.room.*
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@Entity(tableName = "kanji")
data class Kanji(
    @PrimaryKey val symbol: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "level") val level: Int?,
    @ColumnInfo(name = "reading") val reading: String?
)

@Dao
interface KanjiDao {
    @Query("SELECT * FROM kanji")
    fun getAll(): List<Kanji>

    @Insert
    fun insertAll(kanjis: List<Kanji>)

    @Delete
    fun delete(kanji: Kanji)
}

@Database(entities = arrayOf(Kanji::class), version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun kanjiDao() : KanjiDao
}

data class KanjiLevels(var default: String = "default") {
    val kanjiLevelsMap = mapOf(
        "pleasant" to listOf(1,2,3,4,5,6,7,8,9,10),
        "painful" to listOf(11,12,13,14,15,16,17,18,19,20),
        "death" to listOf(21,22,23,24,25,26,27,28,29,30),
        "hell" to listOf(31,32,33,34,35,36,37,38,39,40),
        "paradise" to listOf(41,42,43,44,45,46,47,48,49,50),
        "reality" to listOf(51,52,53,54,55,56,57,58,59,60)
    )
}