package com.example.liaoruochen.roomwordsample.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.liaoruochen.roomwordsample.data.WordRepository
import com.example.liaoruochen.roomwordsample.entity.Word

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private var mWordRepository: WordRepository = WordRepository(application)
    private var mAllWorlds: LiveData<List<Word>>

    init {
        mAllWorlds = mWordRepository.getAllWords()
    }


    fun getAllWords(): LiveData<List<Word>> {
        return mAllWorlds;
    }

    fun insert(word: Word) {
        mWordRepository.insert(word)
    }

}

