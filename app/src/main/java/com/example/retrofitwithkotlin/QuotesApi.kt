package com.example.retrofitwithkotlin

import com.example.example.Root
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("quotes")
    suspend fun getQuotes() : Response<Root>
}