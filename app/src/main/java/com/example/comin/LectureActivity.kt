package com.example.comin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.comin.fragment.ListFragment.FirstFragment
import com.example.comin.fragment.ListFragment.FragmentAdapter
import com.example.comin.fragment.ListFragment.SecondFragment
import com.example.comin.fragment.ListFragment.ThirdFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_lecture.*
import kotlinx.android.synthetic.main.custom_tab.view.*

class LectureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture)

        val adapter = FragmentAdapter(this)
        adapter.fragmentList = getFragmentList()
        list_view_pager.adapter = adapter

        val tabTitles = listOf<String>("A","B","C","D")
        TabLayoutMediator(tab_layout,list_view_pager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()


        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("AI")))




    }

    fun getFragmentList() : List<Fragment> {
        return listOf<Fragment>(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )
    }

    //탭 레이아웃 안에 customTab을 넣어주는 역할
    private fun createTabView(tabName: String) : View {
        val inflater = LayoutInflater.from(this)
        val tabView = inflater.inflate(R.layout.custom_tab,null)
        tabView.txt_name.text = tabName
        return tabView
    }
}