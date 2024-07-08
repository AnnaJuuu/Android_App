package com.example.myself

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        //onCreat안에 있기 때문에 늦은 초기화를 하지 않아도 됨
        val suName = findViewById<EditText>(R.id.et_name)
        val suId = findViewById<EditText>(R.id.et_signId)
        val suPw = findViewById<EditText>(R.id.et_signPW)
        val btnSignUp = findViewById<Button>(R.id.btn_signup)

        btnSignUp.setOnClickListener {
            if (empty(suName) && empty(suId) && empty(suPw)) //조건 3개가 모두 비어있지 않은 경우
            {
                //사용자가 입력한 데이터를 intent에 담아 현재 액티비티를 종료하고, 결과를 호출한 액티비티로 반환하는 역할
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id",suId.text.toString())
                intent.putExtra("pw",suPw.text.toString())
                //결과가 성공적임을 나타나는 상수, 호출한 액티비티에 반환할 데이터가 포함된 intent
                setResult(RESULT_OK, intent)
                finish()
            }
            else Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
        }
    }
    //그냥 isEmpty() 사용해도 되지만 <- 원래 이거 썼지만, 정우님께서 .isNotBlank()로 추천하셔서 변경
    //중복된 코드를 함수로 정의 후 사용하면 더 간결한거 같아서 써봄
    fun empty(et : EditText) : Boolean
    {
        return (et.text.isNotBlank())
    }
}





