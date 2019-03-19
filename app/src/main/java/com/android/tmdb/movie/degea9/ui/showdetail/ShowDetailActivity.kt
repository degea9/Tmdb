package com.android.tmdb.movie.degea9.ui.showdetail

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.ui.top.TmdbViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_show_detail.*
import javax.inject.Inject

class ShowDetailActivity : DaggerAppCompatActivity() {
    companion object {

        const val EXTRA_TVSHOW_ID = "extra_tvshow_id"

    }

    @Inject
    lateinit var viewModelFactory: TmdbViewModelFactory
    lateinit var tvShowDetailViewModel: TvShowDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        tvShowDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(TvShowDetailViewModel::class.java)
        tvShowDetailViewModel.tvShowDetail.observe(this, Observer {
            Log.e("tuandang", "name " + it.name)
        })
        if (intent.hasExtra(EXTRA_TVSHOW_ID)) {
            tvShowDetailViewModel.loadTvShow(intent.getIntExtra(EXTRA_TVSHOW_ID, 0))
        }

        val fragmentAdapter = ShowViewPagerAdapter(supportFragmentManager)
        viewpager.adapter = fragmentAdapter
        tab_layout.setupWithViewPager(viewpager)
    }
}