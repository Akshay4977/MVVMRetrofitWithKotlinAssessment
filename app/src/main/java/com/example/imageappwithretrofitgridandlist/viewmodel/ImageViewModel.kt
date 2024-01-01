package com.example.imageappwithretrofitgridandlist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.imageappwithretrofitgridandlist.models.Item
import com.example.imageappwithretrofitgridandlist.repository.ImageRepo
import com.example.imageappwithretrofitgridandlist.retrofit.RetrofitModule

class ImageViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ImageRepo

    init {
        repository =
            ImageRepo(
                RetrofitModule.ApiClient.apiService
            )
    }

    suspend fun getItemList(): List<Item> {

        return repository.getItemList()
    }

    suspend fun getSearchItemList(query: String): List<Item> {

        return repository.getSearchItemList(query)
    }

}