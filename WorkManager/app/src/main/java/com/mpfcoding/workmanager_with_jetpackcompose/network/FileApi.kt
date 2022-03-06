package com.mpfcoding.workmanager_with_jetpackcompose.network

import com.mpfcoding.workmanager_with_jetpackcompose.utils.Constants
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface FileApi {

    @GET(Constants.COMPLETE_ROOT)
    suspend fun downloadImage(): Response<ResponseBody>

    companion object {
        val instance by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.MAIN_ROOT)
                .build()
                .create(FileApi::class.java)
        }
    }
}