package com.example.rodrigo.newsapp.scenarios_main

import com.example.rodrigo.newsapp.entities.Article

interface MainContract {

    interface View{
         fun showMessage(msg: String)
         fun showList(articles: List<Article>)
        fun showLoading()
        fun hideLoading()

    }

    interface Presenter{
        fun onLoadList()
    }

}