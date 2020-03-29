package com.greedyassignment.network

import com.greedyassignment.models.RedditImageModel
import io.reactivex.Observable
import retrofit2.http.GET

interface IRedditRepositories {

    @GET("hot.json")
    fun getRedditImages(): Observable<RedditImageModel>
}