package com.example.comin.fragment.ListFragment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.R
import com.example.comin.fragment.MarketInfo.MarketInfoActivity
import kotlinx.android.synthetic.main.list_view_item.view.*


class FirstFragAdapter(
    val context: Context,
    val list : ArrayList<ContentListModel>,
): RecyclerView.Adapter<FirstListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_view_item,parent,false)

        return FirstListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FirstListViewHolder, position: Int) {
        val resources = context.resources
        val packageName = context.packageName
        val content = list[position]
        val imgResId = resources.getIdentifier(content.image,"drawable",packageName)
        holder.viewImage1.setImageResource(imgResId)
        holder.tvTitle.text = content.title
        holder.tvContent.text = "최근 리뷰가 ${content.number}개 입니다."
        holder.tvCategory.text = content.category

        holder.itemView.setOnClickListener {
            val intent = Intent(context, MarketInfoActivity::class.java)
            intent.putExtra("title",list[position].title)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}


class FirstListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var viewImage1: ImageView = itemView.lv_image_area
    var tvTitle: TextView = itemView.lv_text_title
    var tvContent: TextView = itemView.lv_text_content
    var tvCategory: TextView = itemView.lv_text_category
//    init {
//        itemView.setOnClickListener {
//            val intent = Intent(itemView.context,MarketInfoActivity::class.java)
//
//        }
//    }
}