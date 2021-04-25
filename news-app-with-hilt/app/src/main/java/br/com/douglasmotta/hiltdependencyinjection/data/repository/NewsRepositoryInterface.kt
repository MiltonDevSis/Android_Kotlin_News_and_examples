package br.com.douglasmotta.hiltdependencyinjection.data.repository

import br.com.douglasmotta.hiltdependencyinjection.data.model.NewsResult

interface NewsRepositoryInterface {

    suspend fun getNews(): NewsResult
}