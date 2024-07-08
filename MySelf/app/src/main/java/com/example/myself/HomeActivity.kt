package com.example.myself

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {

    val imageArray = arrayOf(
            R.drawable.rd_1,
            R.drawable.rd_2,
            R.drawable.rd_3,
            R.drawable.rd_4,
            R.drawable.rd_5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val getIdData = intent.getStringExtra("LoginIdData")
        val etData = findViewById<EditText>(R.id.et_inforId)
        etData.setText(getIdData)

        val btnFinish = findViewById<Button>(R.id.btn_finish)

        val rdimageView = findViewById<ImageView>(R.id.profileim)
        rdimage(rdimageView)

        btnFinish.setOnClickListener {
            finish()
        }
    }

    fun rdimage(imageView: ImageView)
    {
        val rdIndex = (imageArray.indices).random()
        val rdimageRes = imageArray[rdIndex]
        imageView.setImageResource(rdimageRes)
    }
}