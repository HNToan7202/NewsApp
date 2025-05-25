package com.example.mvvm_demo.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.mvvm_demo.api.NewsListModel
import com.example.mvvm_demo.api.UIState
import com.example.mvvm_demo.data.newsSet.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository,
) : ViewModel() {

    val uiState: StateFlow<UIState<PagingData<NewsListModel>>> =
        repository.observePagedNews()
            .map<PagingData<NewsListModel>, UIState<PagingData<NewsListModel>>> { UIState.Success(it) }
            .catch { emit(UIState.Error(it.message ?: "Unknown error")) }
            .onStart { emit(UIState.Loading) }
            .stateIn(viewModelScope, SharingStarted.Lazily, UIState.Loading)

    override fun onCleared() {
        super.onCleared()
    }
}
