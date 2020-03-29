package com.greedyassignment.redditimagedetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.greedyassignment.R
import com.greedyassignment.databinding.RedditImageDetailBinding

class RedditImageDetailsActivity : AppCompatActivity() {
    private lateinit var dataBinding: RedditImageDetailBinding
    private val imageUrl: String?
        get() = intent?.getStringExtra("image_url")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_reddit_image_details)
        dataBinding.redditImageUrl = imageUrl
        dataBinding.executePendingBindings()
    }
}
