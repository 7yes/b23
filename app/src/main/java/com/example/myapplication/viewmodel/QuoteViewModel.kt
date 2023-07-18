package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.QuoteModel
import com.example.myapplication.domain.GetQuoteUseCase
import com.example.myapplication.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private var getQuotesUseCase: GetQuoteUseCase,
    private var getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel(

) {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()
    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result: List<QuoteModel>? = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote: QuoteModel? = getRandomQuoteUseCase()
        if (quote != null) {
            quoteModel.postValue(quote!!)
        }
        isLoading.postValue(false)
    }
}