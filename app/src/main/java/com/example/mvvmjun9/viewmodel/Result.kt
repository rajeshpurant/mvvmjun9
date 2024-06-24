package com.example.mvvmjun9.viewmodel

sealed class Result {
    data class Success(val token: String?) : Result()
    data class Error(val message: String) : Result()
    data class Loading(val isLoading: Boolean) : Result()
}