package com.example.myapplication.data

import com.example.myapplication.data.model.QuoteModel
import com.example.myapplication.data.model.QuoteProvider
import com.example.myapplication.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}