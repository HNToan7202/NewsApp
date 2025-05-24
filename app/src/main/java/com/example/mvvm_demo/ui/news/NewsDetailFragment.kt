package com.example.mvvm_demo.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mvvm_demo.api.NewsListModel
import com.example.mvvm_demo.databinding.FragmentNewsDetailBinding
import kotlin.getValue

class NewsDetailFragment : Fragment() {

    private val args : NewsDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNewsDetailBinding.inflate(inflater,container,false)
        binding.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
        val newsModel = args.newsItem
        populateDetailsFields(newsModel, binding)
        return binding.root
    }

    private fun populateDetailsFields(newsModel: NewsListModel, binding: FragmentNewsDetailBinding) {
        binding.apply {
           // tvSource.text = newsModel.source?.name
            tvDate.text = newsModel.publishedAt
            tvDescDetail.text = newsModel.description
            tvHeadLineDetail.text = newsModel.title
            Glide.with(requireActivity()).load(newsModel.urlToImage).into(imageView)
        }
    }
}
