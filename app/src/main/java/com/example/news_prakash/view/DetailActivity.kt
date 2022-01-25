package com.example.news_prakash.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.news_prakash.R
import com.example.news_prakash.databinding.ActivityDetailBinding
import com.example.news_prakash.model.remote.ArticlesItem

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       detailBinding =  DataBindingUtil.setContentView(this,R.layout.activity_detail)
        if (intent!=null && intent.hasExtra("data")){
            val data = intent.getSerializableExtra("data") as ArticlesItem
            detailBinding.item = data
        }
        detailBinding.backBtn.setOnClickListener {
            onBackPressed()
        }

    }
}