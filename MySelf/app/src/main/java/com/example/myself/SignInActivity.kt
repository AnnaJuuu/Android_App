package com.example.myself

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        //메서드 onCreat안에다 호출
        setResult()
        btn_login()
        btn_signup()
    }

    //
    //활동 간의 결과를 담당하는 객체 생성, 늦은 초기화
    //다른 액티비티를 시작하고 그 결과를 비동기적으로 받아올 수 있는 객체 <타입은 intent를 사용하여 초기활 할 것>
    private lateinit var resultLaunch : ActivityResultLauncher<Intent>

    //onCreat 밖에 있기 때문에 늦은 초기화 사용.
    //lifecycle 때문이다. ? .
    val logId by lazy { findViewById<EditText>(R.id.et_id) }
    val logPW by lazy { findViewById<EditText>(R.id.et_password) }
    val btn_loginv by lazy { findViewById<Button>(R.id.btn_login) }
    val btn_signupv by lazy { findViewById<Button>(R.id.btn_signup) }


    private fun setResult()  //resultLaunch를 초기화하기 위한 메서드
    {
        //resultLaunch 초기화
        resultLaunch = registerForActivityResult(
            //표준 계약을 사용 -> 다른 액티비티를 시작하고 그 결과를 받을 수 있게 함
            //람다 { result -> ... } 액티비티를 시작하고 그 결과를 받을 수 있게 함
            ActivityResultContracts.StartActivityForResult()){ result ->
            //조건문으로 다른 액티비티가 성공적으로 결괄,ㄹ 반환했는지 확인
            //RESULT_OK는 결과가 성공적임을 나타내는 상수!! (반대도 있음)
            if(result.resultCode == RESULT_OK)
            {
                //result.data는 반환된 인텐트를 가리킴 (더 공부할 것)
                //다른 액티비티에서 inputExtra한 값의 이름을 get함 문자열로
                //?: "데이터가 없을 경우 없음 -> 기본값으로 설정"
                val id = result.data?.getStringExtra("id") ?: "없음"
                val pw = result.data?.getStringExtra("pw") ?: "없음"

                logId.setText(id)
                logPW.setText(pw)
            }
        }
    }

    fun btn_login()
    {
       btn_loginv.setOnClickListener {
           val loginData = logId.text.toString()
           val intentLogin = Intent(this, HomeActivity::class.java)
           if (empty(logId) && empty(logPW)) {
               intentLogin.putExtra("LoginIdData", loginData)   //키 : LoginIdData, 값 : loginData
               startActivity (intentLogin)
           } else Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
       }
    }

    fun btn_signup()
    {
        btn_signupv.setOnClickListener {
            val intentSignUp = Intent(this, SignUpActivity::class.java)
            resultLaunch.launch(intentSignUp)
        }

    }


    fun empty(et : EditText) : Boolean
    {
        return if(et.text.isNotBlank()) true
        else false
    }
}

