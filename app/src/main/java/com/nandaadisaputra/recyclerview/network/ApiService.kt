package com.nandaadisaputra.recyclerview.network

import com.nandaadisaputra.recyclerview.model.PostModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("posts/")
    fun getAllPosts(): Observable<List<PostModel>>

}