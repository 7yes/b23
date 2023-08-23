package com.example.myapplication.domain

import com.example.myapplication.data.QuoteRepository
import com.example.myapplication.data.database.entities.toDatabase
import com.example.myapplication.domain.model.Quote
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
             repository.getAllQuoteFromDB()
        }
    }
}