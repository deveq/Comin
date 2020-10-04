package com.example.comin.fragment.MarketInfo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.R
import kotlinx.android.synthetic.main.review_item.view.*

class ReviewAdapter(
    val list_nickname : ArrayList<String>,
    val list_text : ArrayList<String>,
    val list_rating : ArrayList<String>
): RecyclerView.Adapter<ReviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.review_item, parent, false)

        return ReviewViewHolder(view)

    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.nickname.text = list_nickname[position]
        holder.content.text = list_text[position]
        holder.rating.text = list_rating[position]
    }

    override fun getItemCount(): Int {
        return list_nickname.size
    }
}

class ReviewViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val nickname = itemView.review_nickname
    val content = itemView.review_content
    val rating = itemView.review_rating

}