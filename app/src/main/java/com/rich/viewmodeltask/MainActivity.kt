package com.rich.viewmodeltask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rich.viewmodeltask.model.News
import com.rich.viewmodeltask.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recViewConfig()

        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        newsViewModel.getNews()
        newsViewModel.listNews.observe(this, Observer {
            newsAdapter.setDataNews(it as ArrayList<News>)
        })
    }

    fun recViewConfig(){
        newsAdapter = NewsAdapter(ArrayList())
        recView.adapter = newsAdapter
        recView.layoutManager = LinearLayoutManager(this)
        newsAdapter.onClick = {
            val intent = Intent(this, NewsDetailActivity::class.java )
            intent.putExtra("newsData",it)
            startActivity(intent)
        }
    }
}