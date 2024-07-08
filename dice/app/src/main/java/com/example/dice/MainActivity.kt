package com.example.dice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

            val tv_num = findViewById<TextView>(R.id.tv_number)  //import android.annotation.SuppressLint??? 이게 뭐임???
            val btn_dice = findViewById<Button>(R.id.btn_roll)

            //버튼 늘렸을 때를 표현하는 방법
            //.setOnClickListener로 설정 -> 버튼이 눌렸을 때 아래 {} 실행
            btn_dice.setOnClickListener{
                val random = Random //버튼이 눌렸을 때 랜덤 값을 하나 갖고 옴
                val num = random.nextInt(6) + 1 //0부터 시작하기 때문에 +1해줘야함
                //num을 문자열로 변환해서 TestView에 다시 넘겨줌
                tv_num.text = num.toString()  //Int로 받아오기 때문에, 텍스트에 넣으면 toString해줘야 함

                //logcat에서 왼쪽이 태그 값, 오른쪽 메시지 값
                Log.d("MainActivity", "num = ${num.toString()}")
            }
    }
}