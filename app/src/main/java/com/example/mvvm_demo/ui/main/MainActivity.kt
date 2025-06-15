package com.example.mvvm_demo.ui.main

import com.example.mvvm_demo.R
import com.example.mvvm_demo.databinding.ActivityMainBinding
import com.example.mvvm_demo.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun layoutRes(): Int = R.layout.activity_main

    override fun viewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun initView() {}
}