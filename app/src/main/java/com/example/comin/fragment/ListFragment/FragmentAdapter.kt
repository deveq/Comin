package com.example.comin.fragment.ListFragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

//
//class FragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
//    override fun getCount(): Int {
//        return 3
//    }
//
//    override fun getItem(position: Int): Fragment {
//        return when (position) {
//            0 -> FirstFragment()
//            1 -> SecondFragment()
//            else -> ThirdFragment()
//        }
//    }
//}
//
//

class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    var fragmentList = listOf<Fragment>()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}
