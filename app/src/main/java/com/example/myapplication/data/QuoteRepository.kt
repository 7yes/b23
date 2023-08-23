package com.example.myapplication.data

import com.example.myapplication.data.database.dao.QuoteDao
import com.example.myapplication.data.database.entities.QuoteEntity
import com.example.myapplication.data.network.QuoteService
import com.example.myapplication.domain.model.Quote
import com.example.myapplication.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = api.getQuotes()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun getAllQuoteFromDB(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}