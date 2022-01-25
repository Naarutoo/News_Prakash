package com.example.news_prakash.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.news_prakash.model.remote.ArticlesItem
@Dao
interface DataDao {

 @Insert(onConflict = OnConflictStrategy.REPLACE)
 fun addData(articlesItem: ArticlesItem)

 @Query("SELECT * FROM article")
 fun getData():LiveData<List<ArticlesItem>>

 @Query("DELETE FROM article")
 fun deleteAllFromDb()
}