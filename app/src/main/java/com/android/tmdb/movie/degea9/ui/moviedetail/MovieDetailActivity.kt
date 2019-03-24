package com.android.tmdb.movie.degea9.ui.moviedetail

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.databinding.ActivityMovieDetailBinding
import com.android.tmdb.movie.degea9.ui.main.TmdbViewModelFactory
import com.android.tmdb.movie.degea9.ui.moviedetail.adapter.MovieDetailViewPagerAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_show_detail.*
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
        supportActionBar?.setTitle(null);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setHomeButtonEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true)
        movieDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieDetailViewModel::class.java)
        movieDetailViewModel.movieDetail.observe(this, Observer {
            Log.e("tuandang", "movieDetailViewModel movieDetail onChange " + it)
            binding.movie = it
            //supportActionBar?.title = it.title
        })

        movieDetailViewModel.showLoading.observe(this, Observer {
            Log.e("tuandang", "movieDetailViewModel showLoading onChange " + it)
            binding.progressbar.visibility = if(it) View.VISIBLE else View.GONE
        })
        if (intent.hasExtra(EXTRA_MOVIE_ID)) {
            movieDetailViewModel.loadMovie(intent.getIntExtra(EXTRA_MOVIE_ID, 0))
        }
        binding.viewpager.adapter = MovieDetailViewPagerAdapter(applicationContext, supportFragmentManager)
        binding.tablayout.setupWithViewPager(binding.viewpager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
