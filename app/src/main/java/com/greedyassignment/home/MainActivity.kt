package com.greedyassignment.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.greedyassignment.R
import com.greedyassignment.helper.Globals
import com.greedyassignment.models.RedditImageModel
import com.greedyassignment.network.ApiResult
import com.greedyassignment.viewmodels.RedditImageViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), ApiResult {

    private val redditImageAdapter: RedditImageAdapter by lazy { RedditImageAdapter() }
    private val viewModel by viewModel<RedditImageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reddit_image_recycler_view.layoutManager = LinearLayoutManager(this)
        reddit_image_recycler_view.setHasFixedSize(true)
        reddit_image_recycler_view.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        reddit_image_recycler_view.adapter = redditImageAdapter

        viewModel.getRedditImages(this)
    }

    override fun onSuccess(data: Any) {
        setTrendingRepositoryAdapter(data as RedditImageModel)
    }

    private fun setTrendingRepositoryAdapter(redditImageModel: RedditImageModel) {
        redditImageAdapter.items = redditImageModel.data.children
        redditImageAdapter.notifyDataSetChanged()
        stopShimmer()
    }

    override fun onError(error: String?) {
        stopShimmer()
        error?.let { Globals.showToastMessage(this, it) }
    }

    override fun onResume() {
        super.onResume()
        shimmer_view_container.startShimmer()
    }

    override fun onPause() {
        super.onPause()
        shimmer_view_container.stopShimmer()
    }

    private fun stopShimmer() {
        shimmer_view_container.stopShimmer()
        shimmer_view_container.visibility = View.GONE
    }
}
