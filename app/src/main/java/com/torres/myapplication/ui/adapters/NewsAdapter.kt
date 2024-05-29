package com.torres.myapplication.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.torres.myapplication.R
import com.torres.myapplication.data.network.entities.topNews.Data
import com.torres.myapplication.databinding.ItemTopNewsBinding
import com.torres.myapplication.ui.entities.NewsDataUI

class NewsAdapter(
    private val itemList: List<NewsDataUI>,
    private val onClickItem: (NewsDataUI) -> Unit
) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemTopNewsBinding.bind(view)

        fun render(data: NewsDataUI, onClickItem: (NewsDataUI) -> Unit) {

            binding.txtTitleNews.text = data.name
            binding.txtUrlNews.text = data.url
            binding.txtDescNews.text = data.description
            binding.imgNews
                .load(data.image) {
                    placeholder(R.drawable.logo)
                }
            itemView.setOnClickListener {
                onClickItem(data)
            }
            binding.btnDelete.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(
            inflater.inflate(
                R.layout.item_top_news,
                parent,
                false
            )
        )

    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.render(itemList[position], onClickItem)
    }


}