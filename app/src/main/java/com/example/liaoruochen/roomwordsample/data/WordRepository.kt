package com.example.liaoruochen.roomwordsample.data

import android.app.Application
import android.arch.lifecycle.LiveData
import com.example.liaoruochen.roomwordsample.dao.WordDao
import com.example.liaoruochen.roomwordsample.entity.Word
import com.example.liaoruochen.roomwordsample.runOnIoThread

class WordRepository(application: Application) {
    private var mWordDao: WordDao
    private var mAllWords: LiveData<List<Word>>

    init {
        val db = WordRoomDatabase.getDatabase(application)
        mWordDao = db.wordDao()
        mAllWords = mWordDao.getAllWord()
    }

    fun getAllWords(): LiveData<List<Word>> {
        return mAllWords
    }

    fun insert(word: Word) {
        runOnIoThread { mWordDao.insert(word) }

    }
}
