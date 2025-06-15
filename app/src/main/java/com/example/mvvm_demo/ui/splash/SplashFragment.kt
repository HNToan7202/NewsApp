package com.example.mvvm_demo.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.example.mvvm_demo.R
import com.example.mvvm_demo.databinding.FragmentSplashBinding
import com.example.mvvm_demo.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {
    override fun layoutRes(): Int = R.layout.fragment_splash

    override fun viewModelClass(): Class<SplashViewModel> = SplashViewModel::class.java

    override fun initView() {
        val name = "Toan"
        val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment(name)
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(action)
        }, 2000)
    }

}