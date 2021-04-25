package com.example.kotlinflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {

    val languagesData: LiveData<String> = getLanguages().asLiveData()

    fun getLanguages(): Flow<String> { // Flow e o tipo de dados que vai ser retornado nessa stream
        // bloco para emitir os dados
        return flow {
            val languages = listOf(
                "Kotlin",
                "Java",
                "PHP",
                "C++",
                "C#",
                "JavaScript",
                "Python",
                "Ruby"
            )

            for (language in languages){
                emit(language)
                delay(1000L)
            }
        }
    }
}