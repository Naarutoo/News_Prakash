package com.example.news_prakash.model

import androidx.lifecycle.LiveData
import com.example.news_prakash.model.local.DataDao
import com.example.news_prakash.model.remote.Api.Network
import com.example.news_prakash.model.remote.ArticlesItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class Repo(private val datadao: DataDao) {

    fun getDataFromApi(): LiveData<List<ArticlesItem>> {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val list = Network.api.getData("in", "106631ece5a74bf88ff7ca39ca05ac47").articles
                if (list != null) {
                    datadao.deleteAllFromDb()
                }
                list?.forEach {
                    datadao.addData(it!!)
                }

            }catch (e:Exception){
            }
        }
        return datadao.getData()
        }
    }