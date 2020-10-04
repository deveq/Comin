package com.example.comin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.grid_view_item.view.*
import kotlinx.android.synthetic.main.view_pager_activity.view.*

class GridViewAdapter(
    val context: Context,
    val imgList: Array<Int>,
    val textList: Array<String>
) : BaseAdapter() {
    override fun getCount(): Int {
        return textList.size
    }

    override fun getItem(position: Int): Any {
        return imgList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)

        val view : View
        val holder : GridViewHolder

        if(convertView == null) {
            view = inflater.inflate(R.layout.grid_view_item, parent, false)
            holder = GridViewHolder()
            holder.imageView = view.grid_view_img
            holder.textView = view.grid_view_text
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as GridViewHolder
        }
            holder.textView.text = textList[position]
            holder.imageView.setImageResource(imgList[position])


//        val view = inflater.inflate(R.layout.grid_view_item,parent,false)
//        view.grid_view_img.setImageResource(imgList[position])
//        view.grid_view_text.text = textList[position]

        return view
    }
}

class GridViewHolder() {
    lateinit var imageView : ImageView
    lateinit var textView: TextView
}
