package com.example.liaoruochen.roomwordsample.data

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.liaoruochen.roomwordsample.dao.WordDao
import com.example.liaoruochen.roomwordsample.entity.Word
import com.example.liaoruochen.roomwordsample.runOnIoThread

@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao


    companion object {
        @Volatile
        private var instance: WordRoomDatabase? = null


        fun getDatabase(context: Context): WordRoomDatabase {

            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): WordRoomDatabase {
            return Room.databaseBuilder(context, WordRoomDatabase::class.java, "wold_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            runOnIoThread {
                                instance?.wordDao()?.let {
                                    it.deleteAll()
                                    var word = Word("Hello")
                                    it.insert(word)
                                    word = Word("world")
                                    it.insert(word)
                                }

                            }
                        }
                    })
                    .build()

        }


    }
}