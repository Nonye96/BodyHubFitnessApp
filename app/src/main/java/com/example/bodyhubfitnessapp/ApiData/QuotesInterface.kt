package com.example.bodyhubfitnessapp.ApiData

import com.example.bodyhubfitnessapp.Api.Quote
import retrofit2.http.GET

interface QuoteApiService {
    @GET("quotes")
    suspend fun getQuotes(): List<Quote>
}