package com.example.liaoruochen.roomwordsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.liaoruochen.roomwordsample.adapter.WordListAdapter
import com.example.liaoruochen.roomwordsample.entity.Word
import com.example.liaoruochen.roomwordsample.viewmodels.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val wordListAdapter = WordListAdapter(this)
        recyclerview.adapter= wordListAdapter
        recyclerview.layoutManager =LinearLayoutManager(this)

        val mWordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        mWordViewModel.getAllWords().observe(this, Observer<List<Word>> {
            wordListAdapter.submitList(it)
        })



    }
}
