package br.com.douglasmotta.hiltdependencyinjection.data.model

import com.squareup.moshi.Json

data class Article(
    @field:Json(name = "author") val author: String,
    @field:Json(name = "content") val content: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "publishedAt") val publishedAt: String,
    @field:Json(name = "source") val source: Source,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "urlToImage") val urlToImage: String
)