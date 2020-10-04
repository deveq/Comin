package com.example.comin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.comin.Auth.LoginActivity
import com.example.comin.Auth.MyCominActivity
import com.example.comin.zzim.ZzimActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom.*

class MainActivity : AppCompatActivity() {

    lateinit var imageArr : Array<Int>

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        setColorArray()

        val adapter = ViewPagerAdapter(imageArr)
        view_pager.adapter = adapter
        view_pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        dots_indicator.setViewPager2(view_pager)

        setBtnListener()

        val textArr = getGridTextArray()
        val imgArr = getGridImgArray()

        val gridAdapter = GridViewAdapter(this,imgArr,textArr)
        grid_view.adapter = gridAdapter

        grid_view.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this,LectureActivity::class.java)
            startActivity(intent)

        }

        my_page.setOnClickListener {
            //하단 My코민탭. 로그인이 되어있으면 마이페이지로, 안되어있으면 로그인페이지로
            //로그인 된 상태일 경우 auth.currentUser가 null이 아니므로
            if (auth.currentUser == null) {
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, MyCominActivity::class.java)
                startActivity(intent)
            }
            
        }

        zzim_page.setOnClickListener {
            val intent = Intent(this,ZzimActivity::class.java)
            startActivity(intent)
        }


    }



    fun setColorArray() {
        imageArr = arrayOf<Int>(
            R.drawable.ai,
            R.drawable.css,
            R.drawable.html
        )
    }

    fun setBtnListener() {
        next_btn.setOnClickListener {
            view_pager.currentItem += 1
        }

        previous_btn.setOnClickListener {
            view_pager.currentItem -= 1
        }
    }

    fun getGridImgArray(): Array<Int> {
        return arrayOf(
            R.drawable.ai,
            R.drawable.css,
            R.drawable.html,
            R.drawable.id,
            R.drawable.jpg,
            R.drawable.js,
            R.drawable.mp4,
            R.drawable.pdf,
            R.drawable.php,
            R.drawable.png,
            R.drawable.psd,
            R.drawable.tiff
        )
    }

    fun getGridTextArray() : Array<String> {
        return arrayOf(
            "ai",
            "css",
            "html",
            "id",
            "jpg",
            "js",
            "mp4",
            "pdf",
            "php",
            "png",
            "psd",
            "tiff"
        )
    }
}


