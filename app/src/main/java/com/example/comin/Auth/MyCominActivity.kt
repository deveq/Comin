package com.example.comin.Auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_my_comin.*

class MyCominActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_comin)

        auth = Firebase.auth

        //찾으려는 경로까지의 reference를 받아옴
        val docRef = db.collection("users").document(auth.currentUser?.uid.toString())

        //해당 경로에서 uid에 해당하는 nickname을 받아옴
        docRef.get().addOnSuccessListener { documentSnapshot ->

            nickname_area.text = documentSnapshot.get("nickname").toString()

        }





    }
}