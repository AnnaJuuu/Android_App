package com.example.applemarket

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applemarket.databinding.ActivityDetailPageBinding
import com.example.applemarket.databinding.ActivityMainBinding
import java.text.DecimalFormat

class DetailPage : AppCompatActivity() {
    private val binding by lazy { ActivityDetailPageBinding.inflate(layoutInflater) }
    private lateinit var detailData : MyItem

    fun replaseDecimalFormat(num: Int): String {
        return DecimalFormat("#,###").format(num).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.ivBigProfile.setImageResource(detailData.aIcon)
        binding.tvSeller.text = detailData.seller
        binding.tvDetailAddress.text = detailData.aAddress

        binding.tvDetailTitle.text = detailData.aName
        binding.tvIntroduce.text = detailData.introduce

        binding.tvDetailPrice.text = replaseDecimalFormat(detailData.aPrice) + "원"

    }
}