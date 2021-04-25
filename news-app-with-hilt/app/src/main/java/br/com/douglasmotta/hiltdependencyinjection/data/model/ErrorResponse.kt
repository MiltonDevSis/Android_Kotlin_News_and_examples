package br.com.douglasmotta.hiltdependencyinjection.data.model

import com.squareup.moshi.Json

data class ErrorResponse(
    @field:Json(name = "message") val message: String
)