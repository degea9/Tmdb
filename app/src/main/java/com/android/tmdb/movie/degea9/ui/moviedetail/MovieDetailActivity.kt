package com.android.tmdb.movie.degea9.ui.moviedetail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.databinding.ActivityMovieDetailBinding
import com.android.tmdb.movie.degea9.ui.main.TmdbViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*
import javax.inject.Inject

class MovieDetailActivity : DaggerAppCompatActivity() {
    companion object {

        const val EXTRA_MOVIE_ID = "extra_movie_id"

    }

    @Inject
    lateinit var viewModelFactory: TmdbViewModelFactory
    lateinit var movieDetailViewModel: MovieDetailViewModel
    lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setHomeButtonEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true)
        movieDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieDetailViewModel::class.java)
        movieDetailViewModel.movieDetail.observe(this, Observer {
            binding.movie = it
            supportActionBar?.title = it.title
        })

        movieDetailViewModel.showLoading.observe(this, Observer {
            Log.e("tuandang", "tvShowDetailViewModel showLoading onChange " + it)
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })
        if (intent.hasExtra(EXTRA_MOVIE_ID)) {
            movieDetailViewModel.loadMovie(intent.getIntExtra(EXTRA_MOVIE_ID, 0))
        }
    }
}
