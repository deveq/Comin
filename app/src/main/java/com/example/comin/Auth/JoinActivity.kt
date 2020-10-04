package com.example.comin.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.comin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_join.*

class JoinActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        auth = Firebase.auth

        join_login_button.setOnClickListener {

            val password1 = join_password_area.text.toString()
            val password2 = join_password2_area.text.toString()

            if (password1 == password2) {
                val email = join_email_area.text.toString()

                auth.createUserWithEmailAndPassword(email,password1)
                    .addOnCompleteListener(this) { task ->

                        if (task.isSuccessful) {
                            val intent = Intent(this,JoinInfoActivity::class.java)
                            startActivity(intent)

                        } else {
                            Toast.makeText(this,"회원가입에 실패했습니다.",Toast.LENGTH_SHORT).show()
                        }
                    }

            } else {
                Toast.makeText(this,"비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show()
            }



        }






    }
}