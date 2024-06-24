package com.example.mvvmjun9.repositary

import com.example.mvvmjun9.di.ApiService
import com.example.mvvmjun9.model.Post
import javax.inject.Inject

class PostRepository @Inject constructor(private val api: ApiService) {
    suspend fun getPosts(): List<Post> = api.getPosts()
}