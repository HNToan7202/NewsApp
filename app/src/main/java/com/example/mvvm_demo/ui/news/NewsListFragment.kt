package com.example.mvvm_demo.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mvvm_demo.api.NetworkState
import com.example.mvvm_demo.databinding.FragmentNewsListBinding
import com.example.mvvm_demo.commonUtil.ConnectivityUtil
import com.kanchanpal.newsfeed.news.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

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
        val data = newsViewModel.newsList(isConnected)
        data?.networkState?.observe(viewLifecycleOwner, Observer {
            when (it) {
                is NetworkState.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is NetworkState.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                }

                is NetworkState.LOADED -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        })
        data?.pagedList?.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}
