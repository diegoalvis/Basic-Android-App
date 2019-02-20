package com.diegoalvis.android.newsapp.api

import com.example.bairestest.models.Repo

class SearchResponse(var totalCount: Int, val items: MutableList<Repo> = mutableListOf())