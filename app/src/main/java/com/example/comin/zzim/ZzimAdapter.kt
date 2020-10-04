package com.example.comin.zzim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.R
import kotlinx.android.synthetic.main.zzim_item.view.*

class ZzimAdapter(
    val context: Context,
    val list_array: ArrayList<String>
) : RecyclerView.Adapter<ZzimViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZzimViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.zzim_item,parent,false)


        return ZzimViewHolder(view)
    }

    override fun onBindViewHolder(holder: ZzimViewHolder, position: Int) {
        holder.zzimText.text = list_array[position]
    }

    override fun getItemCount(): Int {
        return list_array.size

    }
}

class ZzimViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val zzimText = itemView.zzim_text

}