package com.android.tmdb.movie.degea9.ui.showdetail

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.databinding.ActivityShowDetailBinding
import com.android.tmdb.movie.degea9.ui.showdetail.adapter.ShowViewPagerAdapter
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
    lateinit var binding: ActivityShowDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_detail)
        setSupportActionBar(htab_toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setHomeButtonEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true)
        tvShowDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(TvShowDetailViewModel::class.java)
        tvShowDetailViewModel.tvShowDetail.observe(this, Observer {
            binding.show = it
            supportActionBar?.title = it.name
        })
        if (intent.hasExtra(EXTRA_TVSHOW_ID)) {
            tvShowDetailViewModel.loadTvShow(intent.getIntExtra(EXTRA_TVSHOW_ID, 0))
            tvShowDetailViewModel.getCredit(intent.getIntExtra(EXTRA_TVSHOW_ID, 0))
        }
        viewpager.adapter =
            ShowViewPagerAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(viewpager)
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