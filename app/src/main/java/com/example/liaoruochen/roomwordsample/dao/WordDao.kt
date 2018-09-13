package com.example.liaoruochen.roomwordsample.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.liaoruochen.roomwordsample.entity.Word


@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)


    @Query("DELETE FROM word_table")
    fun deleteAll()


    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWord(): LiveData<List<Word>>

}