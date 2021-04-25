package br.com.douglasmotta.hiltdependencyinjection.data.repository

import android.content.Context
import br.com.douglasmotta.hiltdependencyinjection.data.model.NewsResult
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NewsRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val newsDbDataSource: NewsDbDataSource,
    private val newsApiDataSource: NewsApiDataSource
) : NewsRepositoryInterface {

    override suspend fun getNews(): NewsResult {
        return newsApiDataSource.fetchNews()
    }
}