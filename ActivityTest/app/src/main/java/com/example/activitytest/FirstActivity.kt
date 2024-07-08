package com.example.activitytest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {

    val TAG = "FirstActivity_Lifrcycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)
        Log.i(TAG, "onCreate()")

        val btn1 = findViewById<Button>(R.id.btnFA)

        btn1.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val btn3 = findViewById<Button>(R.id.buttonTA)

        btn3.setOnClickListener {
            //
            val edit_text = findViewById<EditText>(R.id.edit_data)
            val strData = edit_text.text.toString()
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("dataFromFirstActivity", strData)
            startActivity(intent)
        }

    }

    //onCreat 밖으로 붙여놓기
    //doOnBtnClick xml파일에 있는 두 버튼이 다 호출
    fun doOnBtnClick(view: View) {
        //버튼 아이디로 구분
        when (view.getId()) {
            R.id.buttonDA -> {
                val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:114"))   //공백 있음 안됨
                startActivity(callIntent)
            }

            R.id.buttonMA -> {
                val map_intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.565350, 1127.01445"))
                startActivity(map_intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy()")
    }
}