package com.example.rodrigo.newsapp.scenarios_main

import com.example.rodrigo.newsapp.entities.ArticleList
import com.example.rodrigo.newsapp.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainPresenter(val view: MainContract.View) : MainContract.Presenter{

    override fun onLoadList() {

        view.showLoading()

        val newsService = RetrofitInicializer().createNewsService()

        val call = newsService.getEverything("bolsonaro")

        call.enqueue(object : Callback<ArticleList> {
            override fun onFailure(call: Call<ArticleList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<ArticleList>, response: Response<ArticleList>) {
                view.hideLoading()
                if (response.body() != null) {
                    view.showList(response.body()!!.articles)
                }else{
                    view.showMessage("Sem notícias para hoje")
                }
            }
        })
    }

}