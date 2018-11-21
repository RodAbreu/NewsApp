package com.example.rodrigo.newsapp.scenarios_main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rodrigo.newsapp.R
import com.example.rodrigo.newsapp.entities.Article
import com.example.rodrigo.newsapp.utils.GlideApp
import kotlinx.android.synthetic.main.news_item.view.*

class ArticleAdapter(val context: Context, val articles: List<Article>)
    : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.itemClickListener = clique
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, articles[position], itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, article: Article, itemClickListener: ((index: Int) -> Unit)?) {
            itemView.tvTitle.text = article.title

            GlideApp.with(context)
                .load(article.urlToImage)
                .placeholder(R.drawable.no_image)
                .centerCrop()
                .into(itemView.imgNews)

            if(itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }

        }

    }

}