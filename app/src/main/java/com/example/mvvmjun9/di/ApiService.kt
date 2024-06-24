package com.example.mvvmjun9.di

import com.example.mvvmjun9.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}