package com.example.comin.fragment.MarketInfo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Toast
import com.example.comin.R
import com.example.comin.Utils.FirebaseUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_market_info.*

class MarketInfoActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var database : FirebaseFirestore
    private lateinit var uid : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_info)

        val title = intent.getStringExtra("title")
        lecture_text.text = title

        uid = FirebaseUtils.getUid()
        database = FirebaseUtils.database

        // 찜 여부 확인
        database.collection("zzim")
            .document(uid)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.get(title) == true) {
                    zzim.text = "찜 완료"
                    zzim.setTextColor(Color.GRAY)
                }

            }
            .addOnFailureListener {

            }




        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_area,ContentFragment())
            .commit()

        zzim.setOnClickListener {

            //이미 찜 되어있을 경우
            if (zzim.text.equals("찜 완료")) {
                zzim.text = "찜하기"
                zzim.setTextColor(Color.RED)

                database.collection("zzim")
                    .document(uid)
                    .update(title,"")
                    .addOnSuccessListener {
                        Toast.makeText(this,"찜 해제 되었습니다.",Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,"찜 해제 실패 ㅠㅠ",Toast.LENGTH_SHORT).show()
                    }

            } else {
                //찜이 되어있지 않을 경우
                database.collection("zzim")
                    .document(uid)
                    .update(title,true)
                    .addOnSuccessListener {
                        Toast.makeText(this,"성공",Toast.LENGTH_SHORT).show()
                        zzim.apply {
                            text = "찜 완료"
                            setTextColor(Color.GRAY)
                        }
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,"실패",Toast.LENGTH_SHORT).show()
                    }
            }



        }

        figure_1.setOnClickListener {

            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)

            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragment_area,ContentFragment())
                commit()
            }
        }
        figure_2.setOnClickListener {
            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25F)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)

            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragment_area,InfoFragment())
                commit()
            }

        }
        figure_3.setOnClickListener {

            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25F)
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragment_area,ReviewFragment())
                commit()
            }

        }


    }
}