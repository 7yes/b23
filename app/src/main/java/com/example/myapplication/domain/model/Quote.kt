package com.example.myapplication.domain.model

import com.example.myapplication.data.database.entities.QuoteEntity
import com.example.myapplication.data.model.QuoteModel

data class Quote(
    val quote: String, val author: String
)

fun QuoteModel.toDomain() = Quote(quote =  quote, author = author)

fun QuoteEntity.toDomain() =Quote(quote = quote, author = author)