package com.stradivarius.japanesestudy.ui.main.data

import androidx.room.*

/**
 * Database Declaration
 */
@Database(entities = [Kanji::class, Radical::class, Vocabulary::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun kanjiDao() : KanjiDao
    abstract fun radicalDao() : RadicalDao
    abstract fun vocabDao() : VocabularyDao
}

/**
 * Kanji Table
 */
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
    fun insertAll(kanjiList: List<Kanji>)

    @Delete
    fun delete(kanji: Kanji)
}

/**
 * Radical Table
 */
@Entity(tableName = "radicals")
data class Radical(
    @PrimaryKey val name: String,
    @ColumnInfo(name = "symbol") val symbol: String?,
    @ColumnInfo(name = "level") val level: String?,
    @ColumnInfo(name = "symbolImage") val symbolImage: String?
)

@Dao
interface RadicalDao {
    @Query("SELECT * FROM radicals")
    fun getAll(): List<Radical>

    @Insert
    fun insertSingle(radical: Radical)

    @Insert
    fun insertAll(radicalList: List<Radical>)

    @Delete
    fun delete(radical: Radical)
}

/**
 * Vocabulary Table
 */

@Entity(tableName = "vocabulary")
data class Vocabulary(
    @PrimaryKey val symbol: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "reading") val reading: String?,
    @ColumnInfo(name = "level") val level: String?,
    @ColumnInfo(name = "radicals") val radicals: String?
)

@Dao
interface VocabularyDao {
    @Query("SELECT * FROM vocabulary")
    fun getAll(): List<Vocabulary>

    @Insert
    fun insertAll(vocabList: List<Vocabulary>)

    @Delete
    fun delete(radical: Vocabulary)
}

/**
 * Level Breakdown
 */

internal class Levels {
    companion object {
        val levels = mapOf(
            "pleasant" to listOf(1,2,3,4,5,6,7,8,9,10),
            "painful" to listOf(11,12,13,14,15,16,17,18,19,20),
            "death" to listOf(21,22,23,24,25,26,27,28,29,30),
            "hell" to listOf(31,32,33,34,35,36,37,38,39,40),
            "paradise" to listOf(41,42,43,44,45,46,47,48,49,50),
            "reality" to listOf(51,52,53,54,55,56,57,58,59,60)
        ).toList()
    }
}