package com.example.news_prakash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_prakash.model.local.DataDao
import com.example.news_prakash.model.local.TheDatabase
import com.example.news_prakash.model.remote.ArticlesItem
import com.example.news_prakash.model.Repo
import com.example.news_prakash.R
import com.example.news_prakash.ViewModel.MainViewModel
import com.example.news_prakash.ViewModel.ViewModelFactory
import com.example.news_prakash.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemClick {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var repo: Repo
    private lateinit var dataDao: DataDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataDao = TheDatabase.getDatabaseInstance(this).getDao()
        repo = Repo(dataDao)
        viewModel = ViewModelProvider(this, ViewModelFactory(repo)).get(MainViewModel::class.java)

        viewModel.getata().observe(this, Observer {
            val list = it as ArrayList<ArticlesItem>
            setRecyclerView(list)

        })
    }

    private fun setRecyclerView(list: ArrayList<ArticlesItem>) {
        val newsAdapter = NewsAdapter(list,this)
        binding.recyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun onclick(articlesItem: ArticlesItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("data", articlesItem)
        startActivity(intent)
    }

}