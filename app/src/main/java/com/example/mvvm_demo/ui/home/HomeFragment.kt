package com.example.mvvm_demo.ui.home

import androidx.navigation.fragment.navArgs
import com.example.mvvm_demo.R
import com.example.mvvm_demo.databinding.FragmentHomeBinding
import com.example.mvvm_demo.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    val arg: HomeFragmentArgs by navArgs()
    
    override fun layoutRes(): Int = R.layout.fragment_home

    override fun viewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun initView() {
        val name = arg.userName
        binding.tvInfo.text = "Hi: $name"
    }

}