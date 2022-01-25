package com.example.news_prakash.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.DataBindingUtil
import com.example.news_prakash.model.remote.ArticlesItem
import com.example.news_prakash.R
import com.example.news_prakash.databinding.ItemIewBinding


class NewsAdapter(val newslist: ArrayList<ArticlesItem>, private val onItemClick: OnItemClick) :
    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemViewBinding: ItemIewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_iew, parent, false)
        return NewsHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bindData(newslist[position], onItemClick)
    }

    override fun getItemCount(): Int {
        return newslist.size
    }

    class NewsHolder(private val itemViewBinding: ItemIewBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bindData(articlesItem: ArticlesItem, onItemClick: OnItemClick) {
            itemViewBinding.item = articlesItem
            itemViewBinding.itemClick = onItemClick
        }
    }
}