package com.android.tmdb.movie.degea9.ui.moviedetail


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.databinding.FragmentMovieInfoBinding
import com.android.tmdb.movie.degea9.ui.showdetail.TvShowDetailViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MovieInfoFragment : Fragment() {
    lateinit var binding:FragmentMovieInfoBinding

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
            //supportActionBar?.title = it.title
        })
    }

}
