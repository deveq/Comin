package com.example.comin.Utils

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class FirebaseUtils {

    companion object {

        private var auth = Firebase.auth
        var database = FirebaseFirestore.getInstance()

        fun getUid() : String {
            return auth.currentUser?.uid.toString()
        }

    }
}