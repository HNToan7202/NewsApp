package com.example.mvvm_demo.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm_demo.R
import com.example.mvvm_demo.databinding.ActivityMainBinding
import com.example.mvvm_demo.presentation.main.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(this)
        binding.vpPage.adapter = adapter

        binding.vpPage.isUserInputEnabled = false

        binding.bnvData.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.communities -> binding.vpPage.currentItem = 0
                R.id.chat -> binding.vpPage.currentItem = 1
                R.id.setting -> binding.vpPage.currentItem = 2
            }
            return@setOnItemSelectedListener true
        }

    }

    fun toastUtil(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }
}