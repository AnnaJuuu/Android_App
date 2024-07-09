package com.example.instagram

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageBtn1 = findViewById<ImageButton>(R.id.ib_story_1)
        val imageBtn2 = findViewById<ImageButton>(R.id.ib_story_2)
        val imageBtn3 = findViewById<ImageButton>(R.id.ib_story_3)
        val imageBtn4 = findViewById<ImageButton>(R.id.ib_story_4)
        val imageBtn5 = findViewById<ImageButton>(R.id.ib_story_5)


        imageBtn1.setOnClickListener {
            val intent = Intent(this, StoryPage::class.java)
            intent.putExtra("img_src", "story_1")
            startActivity(intent)
        }
        imageBtn2.setOnClickListener {
            val intent = Intent(this, StoryPage::class.java)
            intent.putExtra("img_src", "story_2")
            startActivity(intent)
        }
        imageBtn3.setOnClickListener {
            val intent = Intent(this, StoryPage::class.java)
            intent.putExtra("img_src", "story_3")
            startActivity(intent)
        }
        imageBtn4.setOnClickListener {
            val intent = Intent(this, StoryPage::class.java)
            intent.putExtra("img_src", "story_4")
            startActivity(intent)
        }
        imageBtn5.setOnClickListener {
            val intent = Intent(this, StoryPage::class.java)
            intent.putExtra("img_src", "story_5")
            startActivity(intent)
        }

        val instagram = findViewById<TextView>(R.id.textView)
        val url = "https://www.instagram.com/0_12.22/"
        instagram.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}


/*v*/