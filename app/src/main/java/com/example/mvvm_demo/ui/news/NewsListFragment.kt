package com.example.mvvm_demo.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import com.example.mvvm_demo.api.NewsListModel
import com.example.mvvm_demo.api.UIState
import com.example.mvvm_demo.databinding.FragmentNewsListBinding
import com.example.mvvm_demo.commonUtil.ConnectivityUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsListFragment : Fragment() {
    private var isConnected: Boolean = true
    private lateinit var binding: FragmentNewsListBinding
    private var _binding: FragmentNewsListBinding? = null
    val newsViewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsListBinding.inflate(inflater, container, false)
        context ?: return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isConnected = ConnectivityUtil.isConnected(context)
        if (!isConnected)
            Toast.makeText(
                context?.applicationContext,
                "No internet connection!",
                Toast.LENGTH_SHORT
            ).show()

        val adapter = NewsAdapter()
        binding.rvNewsList.adapter = adapter
        subscribeUI(adapter)
    }

    private fun subscribeUI(adapter: NewsAdapter) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                newsViewModel.uiState.collectLatest { state ->
                    when (state) {
                        is UIState.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }

                        is UIState.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
                        }

                        is UIState.Success<PagingData<NewsListModel>> -> {
                            binding.progressBar.visibility = View.GONE
                            adapter.submitData(state.data)
                        }
                    }
                }
            }
        }
    }
}
