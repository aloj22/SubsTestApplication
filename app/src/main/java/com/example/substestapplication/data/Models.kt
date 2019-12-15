package com.example.substestapplication.data

import com.google.gson.annotations.SerializedName

data class PagingApiResponse<T>(@SerializedName("page") val page: Int, @SerializedName("total_results") val totalResults: Int,
                             @SerializedName("total_pages") val totalPages: Int,
                             @SerializedName("results") val results: List<T>)