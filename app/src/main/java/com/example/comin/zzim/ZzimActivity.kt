package com.example.comin.zzim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comin.R
import com.example.comin.Utils.FirebaseUtils
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_market_info.*
import kotlinx.android.synthetic.main.activity_zzim.*

class ZzimActivity : AppCompatActivity() {

    private lateinit var database : FirebaseFirestore
    private lateinit var uid : String
    private val list_array : ArrayList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zzim)

        database = FirebaseUtils.database
        uid = FirebaseUtils.getUid()

        database.collection("zzim")
            .document(uid)
            .get()
            .addOnSuccessListener { documentSnapshot ->
//
//                if (documentSnapshot.get("lang1") != "") {
//                    list_array.add("lang1")
//                }
//                if (documentSnapshot.get("lang2") != "") {
//                    list_array.add("lang2")
//                }
//                if (documentSnapshot.get("lang3") != "") {
//                    list_array.add("lang3")
//                }
//                if (documentSnapshot.get("lang4") != "") {
//                    list_array.add("lang4")
//                }
//                if (documentSnapshot.get("lang5") != "") {
//                    list_array.add("lang5")
//                }
//                if (documentSnapshot.get("lang6") != "") {
//                    list_array.add("lang6")
//                }
//                if (documentSnapshot.get("lang7") != "") {
//                    list_array.add("lang7")
//                }
//                if (documentSnapshot.get("lang8") != "") {
//                    list_array.add("lang8")
//                }
//                if (documentSnapshot.get("lang9") != "") {
//                    list_array.add("lang9")
//                }
                
                for (snapshot in documentSnapshot.data!!.iterator()) {
                    if (!snapshot.value.equals("")) {
                        list_array.add("${snapshot.key} 냥냥")
                    }
                }


                val zzimAdapter = ZzimAdapter(this,list_array)
                zzim_recycler_view.adapter = zzimAdapter
                zzim_recycler_view.layoutManager = LinearLayoutManager(this)

            }
            .addOnFailureListener {

            }


    }
}