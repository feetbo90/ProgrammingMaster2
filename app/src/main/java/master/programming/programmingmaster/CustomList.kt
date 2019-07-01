package master.programming.programmingmaster

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_custom_list.*
import master.programming.programmingmaster.adapter.movieAdapter
import master.programming.programmingmaster.model.Movie
import android.widget.LinearLayout
import android.widget.Toast


class CustomList : AppCompatActivity(), movieAdapter.onSuggestResultListener {
    override fun onSuggestResult(posisi: Int) {

        Toast.makeText(applicationContext, "${movieList.get(posisi).title}", Toast.LENGTH_LONG).show()

    }


    private val movieList = ArrayList<Movie>()
    private var moviesAdapter : movieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)

        var movie = Movie("Mad Max: Fury Road", "Action & Adventure", "2015")
        movieList.add(movie)

        movie = Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)
        moviesAdapter = movieAdapter(movieList, applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        moviesAdapter?.setOnSuggestResultListener(this)
        recycler_view.adapter = moviesAdapter



    }


    private fun prepareMovieData() {

        var movie = Movie("Mad Max: Fury Road", "Action & Adventure", "2015")
        movieList.add(movie)

        movie = Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)

    }
}
