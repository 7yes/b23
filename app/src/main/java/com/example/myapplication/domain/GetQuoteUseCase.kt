package com.example.myapplication.domain

import com.example.myapplication.data.QuoteRepository
import com.example.myapplication.data.model.QuoteModel
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<QuoteModel> {
        return repository.getAllQuotes()
    }
}