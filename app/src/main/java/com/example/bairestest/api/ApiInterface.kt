package com.diegoalvis.android.newsapp.api

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/search/repositories")
    fun searchRepos(@Query("q") keyWords: String = "android kotlin"): Flowable<SearchResponse>

}