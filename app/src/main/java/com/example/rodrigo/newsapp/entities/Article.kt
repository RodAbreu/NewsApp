package com.example.rodrigo.newsapp.entities

data class Article (val author: String,
                    val title: String,
                    val description: String,
                    val url: String,
                    val urlToImage: String,
                    val publishedAt: String,
                    val content: String)