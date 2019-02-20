package com.example.bairestest.models

data class Repo(
    val name: String,
    val html_url: String,
    val description: String,
    val language: String,
    val watchers: Int
)