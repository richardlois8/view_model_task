package com.rich.viewmodeltask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.rich.viewmodeltask.model.News

class NewsAdapter(var listNews : ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.viewHolder>() {
    var onClick : ((News) -> Unit)? = null

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cvNews = itemView.findViewById<CardView>(R.id.cvNews)
        val image = itemView.findViewById<ImageView>(R.id.imgNews)
        val title = itemView.findViewById<TextView>(R.id.tvTitle)
        val date = itemView.findViewById<TextView>(R.id.tvDate)
//        val description = itemView.findViewById<TextView>(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return viewHolder(v)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.image.setImageResource(listNews[position].image)
        holder.title.text = listNews[position].title
        holder.date.text = listNews[position].date
        holder.cvNews.setOnClickListener{
            onClick?.invoke(listNews[position])
        }
    }

    override fun getItemCount(): Int = listNews.size

    fun setDataNews(data : ArrayList<News>){
        this.listNews = data
    }
}