package com.example.mvvm_demo.ui.detail

import com.example.mvvm_demo.R
import com.example.mvvm_demo.databinding.FragmentDetailBinding
import com.example.mvvm_demo.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {
    override fun layoutRes(): Int = R.layout.fragment_detail

    override fun viewModelClass(): Class<DetailViewModel> = DetailViewModel::class.java

    override fun initView() {
    }
}