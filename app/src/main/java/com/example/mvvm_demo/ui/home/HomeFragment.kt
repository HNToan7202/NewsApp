package com.example.mvvm_demo.ui.home

import com.example.mvvm_demo.R
import com.example.mvvm_demo.databinding.FragmentHomeBinding
import com.example.mvvm_demo.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override fun layoutRes(): Int = R.layout.fragment_home

    override fun viewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun initView() {
    }

}