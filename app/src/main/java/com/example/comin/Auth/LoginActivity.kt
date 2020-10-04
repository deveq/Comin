package com.example.comin.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.comin.MainActivity
import com.example.comin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object {
        const val TAG : String = "로그"
    }

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        login_button.setOnClickListener {

            val email = email_area.text.toString()
            val password = password_area.text.toString()

            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this) {task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        //updateUI(user)
                        Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)

                    } else {
                        Toast.makeText(baseContext,"로그인 실패",Toast.LENGTH_SHORT).show()
                    }
                }

        }

        join_button.setOnClickListener {


            val intent = Intent(this,JoinActivity::class.java)
            startActivity(intent)
        }

    }
}