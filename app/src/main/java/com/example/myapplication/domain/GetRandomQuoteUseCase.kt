package com.example.myapplication.domain

import com.example.myapplication.data.QuoteRepository
import com.example.myapplication.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuoteFromDB()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (0..quotes.size - 1).random()
            return quotes[randomNumber]
        }
        return null
    }
}
