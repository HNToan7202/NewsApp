package com.example.mvvm_demo.ui.base

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mvvm_demo.R
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseActivity<T : ViewDataBinding, M : BaseViewModel> : AppCompatActivity() {

    protected lateinit var binding: T
    protected lateinit var viewModel: M

    private val dialog: AlertDialog by lazy {
        AlertDialog.Builder(this)
            .setView(LayoutInflater.from(this).inflate(R.layout.layout_loading, null))
            .setCancelable(false).create().apply {
                window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
                setCanceledOnTouchOutside(false)
            }
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun viewModelClass(): Class<M>

    protected abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes())
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[viewModelClass()]
        observeErrorState()
        initView()
    }


    private fun observeErrorState() {
        lifecycleScope.launch {
            viewModel.errorState.collectLatest { error ->
                error?.let { showError(it) }
            }
        }
    }

    protected fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (dialog.isShowing) dialog.dismiss()
    }

    fun showLoading() {
        if (!dialog.isShowing) dialog.show()
    }

    fun hideLoading() {
        if (dialog.isShowing) dialog.dismiss()
    }
}