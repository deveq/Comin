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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_join_info.*

class JoinInfoActivity : AppCompatActivity() {

    private val TAG = "JoinInfoActivity"

    private lateinit var database : FirebaseFirestore
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_info)

        auth = Firebase.auth

        database = FirebaseFirestore.getInstance()

        join_info_login_button.setOnClickListener {

            val nickname = join_info_email_area.text.toString()

//            database
//                .child(auth.currentUser?.uid.toString())
//                .setValue(nickname)
//                .addOnSuccessListener {
//                    val intent = Intent(this,MainActivity::class.java)
//                    startActivity(intent)
//                }
//                .addOnFailureListener {
//                    Toast.makeText(this,"실패햇써요..ㅜㅜ",Toast.LENGTH_SHORT).show()
//                }

            val user = hashMapOf(
                "nickname" to join_info_email_area.text.toString()
            )

            database.collection("users")
                .document(auth.currentUser?.uid.toString())  //하위 디렉토리를 한단계 더 만들어줌.
                .set(user)
                .addOnSuccessListener {
                    Log.e("JoinInfoActivity","성공")
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener {
                    Log.e("JoinInfoActivity","실패")

                }






        }

    }
}