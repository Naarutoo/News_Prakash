package com.example.news_prakash.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.news_prakash.model.remote.ArticlesItem

@Database(entities = [ArticlesItem::class], version = 1)
abstract class TheDatabase : RoomDatabase() {
    abstract fun getDao(): DataDao

    companion object {
        private var INSTANCE: TheDatabase? = null

        fun getDatabaseInstance(context: Context): TheDatabase {
            return if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    TheDatabase::class.java,
                    "theDatabae"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                INSTANCE!!
            } else INSTANCE!!
        }
    }
}