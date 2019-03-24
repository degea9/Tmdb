package com.android.tmdb.movie.degea9.ui.moviedetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.ui.moviedetail.adapter.CastAdapter
import com.android.tmdb.movie.degea9.ui.moviedetail.adapter.ReviewAdapter
import kotlinx.android.synthetic.main.fragment_movie_cast.*
import kotlinx.android.synthetic.main.fragment_movie_review.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MovieReviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_review, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_reviews.layoutManager = GridLayoutManager(context, 1)
        val movieDetailViewModel = ViewModelProviders.of(activity!!).get(MovieDetailViewModel::class.java)
        movieDetailViewModel.reviews.observe(viewLifecycleOwner, Observer {
            rv_reviews.adapter = ReviewAdapter(it)
        })

        movieDetailViewModel.loadReview()
    }
}
