package com.example.mvvm_demo.api

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

/**
 * Data class that is necessary for a UI to show a listing and interact w/ the rest of the system
 */
data class Data<T : Any>(
    // the LiveData of paged lists for the UI to observe
    val pagedList: Flow<PagingData<T>>,
    // represents the network request status to show to the user
    val networkState: StateFlow<NetworkState>
)
