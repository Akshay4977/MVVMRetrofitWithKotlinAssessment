package com.example.imageappwithretrofitgridandlist.models


data class ApiResult(
    val total: Int,
    val totalHits: Int,
    val hits: List<Item>

)