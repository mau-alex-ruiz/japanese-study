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
 * Base Entity Class
 */

open class BaseDataTable(
    var symbolEntry: String? = null,
    var symbolURLEntry: String? = null,
    var nameEntry: String? = null,
    var readingEntry: String? = null,
    var levelEntry: String? = null,
    var radicalsEntry: String? = null
)

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
) : BaseDataTable(symbol, null, name, reading, level, radicals)

@Dao
interface VocabularyDao {
    @Query("SELECT * FROM vocabulary")
    fun getAll(): List<Vocabulary>

    @Query("SELECT * FROM vocabulary WHERE level IS (:selectedLevel)")
    fun getSelected(selectedLevel: String) : List<Vocabulary>

    @Query("SELECT * FROM vocabulary WHERE level IN (:selectedLevels) ORDER BY RANDOM()")
    fun getSelected(selectedLevels: List<String>) : List<Vocabulary>

    @Insert
    fun insertAll(vocabList: List<Vocabulary>)

    @Delete
    fun delete(radical: Vocabulary)
}

/**
 * Kanji Table
 */
@Entity(tableName = "kanji")
data class Kanji(
    @PrimaryKey val symbol: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "reading") val reading: String?,
    @ColumnInfo(name = "level") val level: String?
) : BaseDataTable(symbol, null, name, reading, level, null)

@Dao
interface KanjiDao {
    @Query("SELECT * FROM kanji")
    fun getAll(): List<Kanji>

    @Query("SELECT * FROM kanji WHERE level IS (:selectedLevel)")
    fun getSelected(selectedLevel: String) : List<Kanji>

    @Query("SELECT * FROM kanji WHERE level IN (:selectedLevels) ORDER BY RANDOM()")
    fun getSelected(selectedLevels: List<String>) : List<Kanji>

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
) : BaseDataTable(symbol, symbolImage,  name, null, level, null)

@Dao
interface RadicalDao {
    @Query("SELECT * FROM radicals")
    fun getAll(): List<Radical>

    @Query("SELECT * FROM radicals WHERE level IS (:selectedLevel)")
    fun getSelected(selectedLevel: String) : List<Radical>

    @Query("SELECT * FROM radicals WHERE level IN (:selectedLevels) ORDER BY RANDOM()")
    fun getSelected(selectedLevels: List<String>) : List<Radical>

    @Insert
    fun insertSingle(radical: Radical)

    @Insert
    fun insertAll(radicalList: List<Radical>)

    @Delete
    fun delete(radical: Radical)
}

/**
 * Level Breakdown
 */

internal class Levels {
    companion object {
        val levelCategories = listOf("Pleasant", "Painful", "Death", "Hell", "Paradise", "Reality")

        val levels = mutableMapOf<String, List<String>>().apply {
            levelCategories.forEachIndexed { idx, category ->
                this[category] = listOf(1,2,3,4,5,6,7,8,9,10).mapIndexed{i, _ -> (idx*10 + i + 1).toString()}
            }
        }
    }
}