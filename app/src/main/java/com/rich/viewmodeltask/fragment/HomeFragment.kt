package com.rich.viewmodeltask.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rich.viewmodeltask.NewsAdapter
import com.rich.viewmodeltask.R
import com.rich.viewmodeltask.model.News
import com.rich.viewmodeltask.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recViewConfig()

        newsViewModel = ViewModelProvider(requireActivity()).get(NewsViewModel::class.java)
        newsViewModel.getNews()
        newsViewModel.listNews.observe(viewLifecycleOwner, Observer {
            newsAdapter.setDataNews(it as ArrayList<News>)
        })
    }

    fun recViewConfig(){
        newsAdapter = NewsAdapter(ArrayList())
        recView.adapter = newsAdapter
        recView.layoutManager = LinearLayoutManager(context)
        newsAdapter.onClick = {
            val action = HomeFragmentDirections.actionHomeFragmentToNewsDetailFragment(it)
            findNavController().navigate(action)
        }
    }
}