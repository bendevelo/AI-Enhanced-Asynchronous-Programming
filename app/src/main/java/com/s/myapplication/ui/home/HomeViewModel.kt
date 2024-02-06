package com.s.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s.myapplication.Orders
import com.s.myapplication.ReaderEngine.Analitics
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {


    fun Analitics(text:String){
        viewModelScope.launch {

            val AnaliticsEnglish = Analitics(language = "en")
            updateUI(AnaliticsEnglish.scoreToWords(text))
        }

    }

    var liveData: MutableLiveData<String>? = null
    private suspend fun updateUI(text: String) {
        liveData = MutableLiveData<String>().apply {
            value = text
        }

    }

}