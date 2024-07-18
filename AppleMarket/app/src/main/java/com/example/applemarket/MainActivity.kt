package com.example.applemarket

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applemarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        //Adapter
        val adapter = MarketAdapter(ProductManager().products)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // 뒤로 가기
        // 뒤로가기를 onBackPressedDispatcher를 통해 등록
        onBackPressedDispatcher.addCallback(this,onBackPressedCallback)
    }

    // 뒤로가기 버튼 눌렀을 때 실행되는 콜백메소드
    private val onBackPressedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            // 뒤로가기 실행시 실행할 동작코드 구형하기!
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("종료하시겠습니까?")
                .setNegativeButton("취소") { dialog, which -> return@setNegativeButton }
                .setPositiveButton("확인") { dialog, which -> finish() }
                .show()
        }
    }



}