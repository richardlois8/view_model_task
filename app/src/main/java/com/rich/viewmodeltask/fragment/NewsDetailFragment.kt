package com.rich.viewmodeltask.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rich.viewmodeltask.R
import kotlinx.android.synthetic.main.fragment_news_detail.*
import kotlinx.android.synthetic.main.toolbar.view.*

class NewsDetailFragment : Fragment() {
    private val args : NewsDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()

        toolbarDetail.btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_newsDetailFragment_to_homeFragment)
        }
    }

    fun getData(){
        val receivedNewsData = args.newsData
        tvNewsDetailTitle.text = receivedNewsData.title
        imgNewsDetailPhoto.setImageResource(receivedNewsData.image)
        tvNewsDetailWriter.text = receivedNewsData.jurnalis
        tvNewsDetailDate.text = receivedNewsData.date
        tvNewsDetailDesc.text = receivedNewsData.description
    }
}