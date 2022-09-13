package com.rich.viewmodeltask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rich.viewmodeltask.model.News
import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlinx.android.synthetic.main.news_item.*

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        getData()
    }

    fun getData(){
        val receivedNewsData = intent.getSerializableExtra("newsData") as News
        tvNewsDetailTitle.text = receivedNewsData.title
        imgNewsDetailPhoto.setImageResource(receivedNewsData.image)
        tvNewsDetailWriter.text = receivedNewsData.jurnalis
        tvNewsDetailDate.text = receivedNewsData.date
        tvNewsDetailDesc.text = receivedNewsData.description
    }
}