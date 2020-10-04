package com.example.comin.fragment.MarketInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.comin.MainActivity
import com.example.comin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.fragment_review.*

class WriteActivity : AppCompatActivity() {

    lateinit var database : FirebaseFirestore
    lateinit var auth : FirebaseAuth
    lateinit var ratingNum : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)


        auth = Firebase.auth
        database = FirebaseFirestore.getInstance()


        //닉네임 받아오기 (Firestore에서 값 한개 받아오기)
        var nickname : String = ""

        //reference를 찾아옴.  (referecne : 데이터(닉네임)가 저장된 경로)
        val docRef = database.collection("users").document(auth.currentUser?.uid.toString())

        docRef.get().addOnSuccessListener { documentSnapshot ->
            nickname = documentSnapshot.get("nickname") as String
        }

        rating_area.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            ratingNum = rating.toString()
        }

        writing_btn.setOnClickListener {

            val form = hashMapOf(
                "text" to text_input_area.text.toString(),
                "writer" to nickname,  //닉네임이 비어있는지 확인
                "rating" to ratingNum
            )
            database.collection("reviews")
                .add(form)
                .addOnSuccessListener {
                    Toast.makeText(this,"리뷰 올리기 성공",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this,"리뷰 올리기 실패 ㅠㅠㅠ",Toast.LENGTH_SHORT).show()
                }
        }





    }
}