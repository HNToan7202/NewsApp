package com.example.mvvm_demo.api

sealed class UIState<out T> {
    object Loading : UIState<Nothing>()
    data class Success<out T>(val data: T) : UIState<T>()  // ✅ đúng
    data class Error(val message: String) : UIState<Nothing>()
}