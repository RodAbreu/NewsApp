package com.example.rodrigo.newsapp.scenarios_main

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.rodrigo.newsapp.R
import com.example.rodrigo.newsapp.entities.Article
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a1 = Article(
            author = "johnu78",
            title = "Where is Litecoin Going?",
            description = "I’ve been a fan of Litecoin since I first learned about it in 2013. The coin has many good fundamentals to it and I believe that Charlie Lee, the coin’s creator did things right as far as how he created the coin and how he worked to develop it. Towards the en…",
            url = "https://cointrader21.wordpress.com/2018/11/08/where-is-litecoin-going/",
            urlToImage = "https://cointrader21.files.wordpress.com/2018/11/litecoinlogo.png",
            publishedAt = "2018-11-08T17:35:17Z",
            content = "I’ve been a fan of Litecoin since I first learned about it in 2013. The coin has many good fundamentals to it and I believe that Charlie Lee, the coin’s creator did things right as far as how he created the coin and how he worked to develop it. Towards the en… [+1311 chars]"
        )

        val a2 = Article(
            author = "Yashu Gola",
            title = "Bitcoin Analysis: BTC Faces Bearish Reversal as Dollar Strengthens",
            description = "The bitcoin-to-dollar exchange rate has dipped close to 1 percent on Thursday, now trading at 6470-fiat. The outcome of the US midterm elections with Democrats sweeping a sharp win in the House had certainly shaken the US dollar yesterday. The greenback never…",
            url = "https://www.ccn.com/bitcoin-analysis-btc-faces-bearish-reversal-as-dollar-strengthens/",
            urlToImage = "https://www.ccn.com/wp-content/uploads/2018/09/bitcoin-dominance-flex-muscles.jpg",
            publishedAt = "2018-11-08T17:32:48Z",
            content = "The bitcoin-to-dollar exchange rate has dipped close to 1 percent on Thursday, now trading at 6470-fiat. The outcome of the US midterm elections with Democrats sweeping a sharp win in the House had certainly shaken the US dollar yesterday. The greenback never… [+2862 chars]"
        )

        val testList = listOf(a1, a2)

        exibeLista(testList)

    }

    fun exibeLista(list: List<Article>) {

        val adapter = ArticleAdapter(this, list)
        adapter.setOnItemClickListener {position ->
            val openBrowser = Intent(Intent.ACTION_VIEW)
            openBrowser.data = Uri.parse(list.get(position).url)
            startActivity(openBrowser)
        }

        rvNews.adapter = adapter
        rvNews.layoutManager = LinearLayoutManager(this)
    }
}
