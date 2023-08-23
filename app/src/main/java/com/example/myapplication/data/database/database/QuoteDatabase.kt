package com.example.myapplication.data.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.database.dao.QuoteDao
import com.example.myapplication.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase:RoomDatabase() {
    abstract fun getQuoteDao():QuoteDao
}