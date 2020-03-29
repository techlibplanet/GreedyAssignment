package com.greedyassignment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greedyassignment.databinding.RedditImageItemBinding
import com.greedyassignment.models.Children

class RedditImageAdapter : RecyclerView.Adapter<RedditImageViewHolder>() {

    var items: List<Children> = emptyList()
    private lateinit var context: Context
    private lateinit var dataBinding: RedditImageItemBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RedditImageViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        dataBinding = RedditImageItemBinding.inflate(inflater, parent, false)
        return RedditImageViewHolder(dataBinding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RedditImageViewHolder, position: Int) {
        holder.bind(items[position], context)
    }
}