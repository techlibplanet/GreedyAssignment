package com.greedyassignment.home

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.greedyassignment.databinding.RedditImageItemBinding
import com.greedyassignment.models.Children
import com.greedyassignment.redditimagedetails.RedditImageDetailsActivity

class RedditImageViewHolder(private val dataBinding: RedditImageItemBinding) :
    RecyclerView.ViewHolder(dataBinding.root) {
    fun bind(
        model: Children,
        context: Context
    ) {
        dataBinding.redditImageModel = model
        dataBinding.executePendingBindings()

        itemView.setOnClickListener {
            context.startActivity(
                Intent(context, RedditImageDetailsActivity::class.java).putExtra(
                    "image_url",
                    model.data.url
                )
            )
        }
    }
}