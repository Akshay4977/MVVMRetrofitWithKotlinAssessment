package com.example.imageappwithretrofitgridandlist.repository

import com.example.imageappwithretrofitgridandlist.models.Item
import com.example.imageappwithretrofitgridandlist.retrofit.ImageApi
import com.example.imageappwithretrofitgridandlist.retrofit.RetrofitModule
import com.example.imageappwithretrofitgridandlist.utils.Constants.Companion.key
import retrofit2.awaitResponse

class ImageRepo(imageApi: ImageApi) {
    val imagesApi = RetrofitModule.ApiClient.apiService

    suspend fun getItemList(): List<Item> {

        return try {

            val response = imagesApi.getData1(key)?.awaitResponse()
            if (response!!.isSuccessful) {
                val list = response?.body()?.hits ?: emptyList()
                list.map { item -> item }
            } else {
                emptyList()
            }
        } catch (exception: Exception) {
            emptyList()
        }
    }

    suspend fun getSearchItemList(query: String): List<Item> {

        return try {
            val response = imagesApi.getSearchedData(key, query, "photo")?.awaitResponse()
            if (response!!.isSuccessful) {
                val list = response?.body()?.hits ?: emptyList()
                list.map { item -> item }
            } else {
                emptyList()
            }
        } catch (exception: Exception) {
            emptyList()
        }
    }
}
