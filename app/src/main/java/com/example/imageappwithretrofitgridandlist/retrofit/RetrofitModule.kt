package com.example.imageappwithretrofitgridandlist.retrofit

import com.example.imageappwithretrofitgridandlist.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    object RetrofitClient {

        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    object ApiClient {
        val apiService: ImageApi by lazy {
            RetrofitClient.retrofit.create(ImageApi::class.java)
        }
    }
}
