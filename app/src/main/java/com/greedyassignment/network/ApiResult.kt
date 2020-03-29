package com.greedyassignment.network

interface ApiResult {
    fun onSuccess(data: Any)
    fun onError(error: String?)
}