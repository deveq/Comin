package com.example.comin.fragment.MarketInfo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.comin.R
import kotlinx.android.synthetic.main.list_view_item.view.*

class ListAdapter(
    val context: Context,
    val listPrice: ArrayList<String>,
    val listName: ArrayList<String>
) : BaseAdapter() {
    override fun getCount(): Int {
        return listName.size
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_view_item,null)
        view.lv_text_title.text = listName[position]
        view.lv_text_category.text = listPrice[position]

        return view
    }
}