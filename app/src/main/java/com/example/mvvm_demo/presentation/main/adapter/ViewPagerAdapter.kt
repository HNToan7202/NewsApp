package com.example.mvvm_demo.presentation.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mvvm_demo.presentation.chat.ChatFragment
import com.example.mvvm_demo.presentation.home.HomeFragment
import com.example.mvvm_demo.presentation.setting.SettingFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> ChatFragment()
            2 -> SettingFragment()
            else -> HomeFragment()
        }

    }

    override fun getItemCount(): Int = 3
}