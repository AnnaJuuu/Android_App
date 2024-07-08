package com.example.activitytest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        //FirstActivity에서 dataFromFirstActivity이 키값으로 데이터 보냄
        //받을 땐 getStringExtra로 키값 설정해서 받음
        val strData = intent.getStringExtra("dataFromFirstActivity")
        val editText = findViewById<EditText>(R.id.et_third)
        editText.setText(strData)

        val btn_close = findViewById<Button>(R.id.buttonThirdActivity)
        btn_close.setOnClickListener {
            finish()
        }

    }
}