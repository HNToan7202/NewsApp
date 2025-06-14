package com.example.mvvm_demo.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mvvm_demo.presentation.main.MainActivity
import com.example.mvvm_demo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {

    private var btnClickMe: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    //khởi tạo dữ liệu, gọi findById
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //muốn gọi activity cha, sau đó ép kiểu về activity mà chúng ta muốn
        //bị lỗi khi activity ép về bị bull
        //as? trong trường hợp ép kiểu thất bại thiì kết quả trả về null

//        (activity as MainActivity).toastUtil("hihi toan")


        btnClickMe = view.findViewById<Button>(R.id.btnClickMe)
        btnClickMe?.setOnClickListener {
            (activity as? MainActivity)?.toastUtil("hihi toan")
        }

        val text = arguments?.getString("key01", "")
        btnClickMe?.text = text
    }

    companion object {
        //viết cac key, hằng số
        const val NAME = "Nguyen Hoang Toan"
        fun newFragment(data: String): NewsListFragment {
            val fragment = NewsListFragment()
            val bundle = Bundle()

            bundle.putString("key01", data)
            bundle.putString("key01", data)

            fragment.arguments = bundle
            return fragment
        }
    }

}