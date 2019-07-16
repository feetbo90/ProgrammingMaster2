package master.programming.programmingmaster.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import master.programming.programmingmaster.R
import kotlinx.android.synthetic.main.activity_custom_list.*
import master.programming.programmingmaster.adapter.movieAdapter
import master.programming.programmingmaster.model.Movie


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class FragmentList : ListFragment() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var viewManager: RecyclerView.LayoutManager
    //private val YES = 0
    //private val NO = 1

    private val movieList = ArrayList<Movie>()
    private var moviesAdapter : movieAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_list_layout, container, false)
        recyclerView = rootView.findViewById(R.id.recycler_view)
        return rootView
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewManager = LinearLayoutManager(activity)
        var movie = Movie("Mad Max: Fury Road", "Action & Adventure", "2015")
        movieList.add(movie)

        movie = Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)

        moviesAdapter = movieAdapter(movieList, context!!.applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)

        //moviesAdapter?.setOnSuggestResultListener(activity)
        recycler_view.adapter = moviesAdapter

    }





}
