package com.example.myapplication.domain

import com.example.myapplication.data.model.QuoteModel
import com.example.myapplication.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteProvider: QuoteProvider
) {
    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (0..quotes.size - 1).random()
            return quotes[randomNumber]
        }
        return null
    }
}