package com.example.imageappwithretrofitgridandlist.retrofit

import com.example.imageappwithretrofitgridandlist.models.ApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ImageApi {

    @GET("?")
    fun getData1(@Query("key") key: String): Call<ApiResult?>?

    @GET("?")
    fun getSearchedData(@Query("key") key: String,
                        @Query("q") q: String,
                        @Query("image_type") imageType: String): Call<ApiResult?>?

}