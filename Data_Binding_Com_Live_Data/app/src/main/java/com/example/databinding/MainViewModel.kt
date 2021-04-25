package com.example.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var number = 1

    private val _contador = MutableLiveData<String>()
    val contador: LiveData<String> = _contador

    init {
        _contador.value = number.toString()
    }

    fun incrementa(){
        _contador.value = (++number).toString()
    }

    fun decrementa(){
        _contador.value = (--number).toString()
    }
}