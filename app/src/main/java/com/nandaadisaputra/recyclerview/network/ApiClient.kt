package com.nandaadisaputra.recyclerview.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

        val BASE_URL = "https://jsonplaceholder.typicode.com/"
//    private const val BASE_URL = BuildConfig.BASE_URL_POST
    fun client(): ApiService {
        val gSon = GsonBuilder().create()
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gSon))
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)
    }

}