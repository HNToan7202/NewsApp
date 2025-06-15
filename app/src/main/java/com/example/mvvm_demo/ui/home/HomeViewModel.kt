package com.example.mvvm_demo.ui.home

import androidx.lifecycle.viewModelScope
import com.example.mvvm_demo.common.KEYWORD_BITCOIN
import com.example.mvvm_demo.data.RemoteRepository
import com.example.mvvm_demo.data.remote.NewsService
import com.example.mvvm_demo.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
) : BaseViewModel() {
    init {
        getAllNewsList()
    }

    private fun getAllNewsList() {
        viewModelScope.launch {
            remoteRepository.getTopNewList(0, 30, KEYWORD_BITCOIN)
        }
    }
}