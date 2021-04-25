package br.com.douglasmotta.hiltdependencyinjection.data.repository

import br.com.douglasmotta.hiltdependencyinjection.data.model.NewsResult

interface NewsApiDataSource {

    suspend fun fetchNews(): NewsResult
}