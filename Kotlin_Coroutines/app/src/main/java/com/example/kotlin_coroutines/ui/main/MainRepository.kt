package com.example.kotlin_coroutines.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.withContext

class MainRepository {

    fun getFimes(callback: (filmes: List<Filme>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000)

            callback.invoke(
                listOf(
                    Filme(1, "Hulk"),
                    Filme(2, "Homen Aranha")
                )
            )
        }).start()
    }

    suspend fun getFilmesCoroutines(): List<Filme> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Filme(1, "Hulk"),
                Filme(2, "Homen Aranha")
            )
        }
    }
}