package com.example.mvvmjun9.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmjun9.model.Post
import com.example.mvvmjun9.repositary.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    fun fetchPosts() {
        Log.d("ddd","fetchposts is calling")
        viewModelScope.launch {
            try {
                val posts = repository.getPosts()
                _posts.value = posts
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle the exception
            }
        }
    }
}