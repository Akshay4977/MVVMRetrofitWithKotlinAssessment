package com.example.imageappwithretrofitgridandlist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.imageappwithretrofitgridandlist.models.Item
import com.example.imageappwithretrofitgridandlist.repository.ImageRepo
import com.example.imageappwithretrofitgridandlist.retrofit.RetrofitModule
import kotlinx.coroutines.launch

class ImageViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ImageRepo

    var _itemList = MutableLiveData<List<Item>>()
    var itemList = _itemList

    init {
        repository =
            ImageRepo(
                RetrofitModule.ApiClient.apiService
            )
        //getItemList()
    }

    fun getItemList(): LiveData<List<Item>> {
        viewModelScope.launch {
            _itemList.value = repository.getItemList()
        }
        return itemList
    }

    fun getSearchItemList(query: String): LiveData<List<Item>> {
        viewModelScope.launch {
            _itemList.value = repository.getSearchItemList(query)
        }
        return itemList
    }
}