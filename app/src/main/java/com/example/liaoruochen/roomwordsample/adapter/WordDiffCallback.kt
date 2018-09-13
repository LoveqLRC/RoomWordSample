package com.example.liaoruochen.roomwordsample.adapter

import android.support.v7.util.DiffUtil
import com.example.liaoruochen.roomwordsample.entity.Word

class WordDiffCallback : DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {

        return oldItem.word.equals(newItem.word)
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.word .equals( newItem.word)
    }
}