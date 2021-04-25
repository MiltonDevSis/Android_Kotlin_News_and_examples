package br.com.douglasmotta.hiltdependencyinjection.data

import br.com.douglasmotta.hiltdependencyinjection.BuildConfig
import br.com.douglasmotta.hiltdependencyinjection.data.model.ErrorResponse
import br.com.douglasmotta.hiltdependencyinjection.data.model.NewsResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiClient {

    @GET("top-headlines?country=br")
    suspend fun getNews(
        @Query("category") category: String = "technology",
        @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY
    ): NetworkResponse<NewsResponse, ErrorResponse>
}