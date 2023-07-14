package com.example.myapplication.domain

import com.example.myapplication.data.QuoteRepository
import com.example.myapplication.data.model.QuoteModel
import com.example.myapplication.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    private val repository = QuoteRepository()

    operator fun invoke():QuoteModel?{
        val quotes= QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (0..quotes.size-1).random()
            return quotes[randomNumber]
        }
        return null
    }
}