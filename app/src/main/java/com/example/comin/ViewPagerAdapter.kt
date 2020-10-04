package com.example.comin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_pager_activity.view.*

class ViewPagerAdapter(val imageArr: Array<Int>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_pager_activity,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItemView(imageArr[position])
    }

    override fun getItemCount(): Int {
        return imageArr.size
    }
}


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val image = itemView.image_view

    fun bindItemView(resImage: Int) {
        image.setImageResource(resImage)
    }
}