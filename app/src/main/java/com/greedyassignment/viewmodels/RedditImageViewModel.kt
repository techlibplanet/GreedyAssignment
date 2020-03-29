package com.greedyassignment.viewmodels

import androidx.lifecycle.ViewModel
import com.greedyassignment.helper.processRequest
import com.greedyassignment.network.ApiResult
import com.greedyassignment.network.IRedditRepositories
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

class RedditImageViewModel(
    private val redditRepositoryService: IRedditRepositories
) : ViewModel() {

    private var disposable: CompositeDisposable = CompositeDisposable()

    fun getRedditImages(callback: ApiResult) {
        disposable.add(redditRepositoryService.getRedditImages()
            .processRequest(
                {
                    Timber.d(it.toString())
                    callback.onSuccess(it)
                }, {
                    Timber.d(it)
                    it?.let { err -> callback.onError(err) }
                }
            ))
    }
}