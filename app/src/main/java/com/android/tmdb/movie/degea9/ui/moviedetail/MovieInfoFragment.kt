package com.android.tmdb.movie.degea9.ui.moviedetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.databinding.FragmentMovieInfoBinding
import com.android.tmdb.movie.degea9.ui.moviedetail.adapter.TrailerAdapter
import kotlinx.android.synthetic.main.fragment_movie_info.*


/**
 * A simple [Fragment] subclass.
 *
 */
class MovieInfoFragment : Fragment() {
    lateinit var binding: FragmentMovieInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_info, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val movieDetailViewModel = ViewModelProviders.of(activity!!).get(MovieDetailViewModel::class.java)
        binding.setLifecycleOwner(viewLifecycleOwner)

        movieDetailViewModel.movieDetail.observe(viewLifecycleOwner, Observer {
            binding.movie = it
            rv_movie_trailers.adapter =  TrailerAdapter(it.videos.results)
        })


    }

}
