package com.android.tmdb.movie.degea9.ui.main.movie


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.databinding.FragmentMainBinding
import com.android.tmdb.movie.degea9.ui.main.TmdbViewModelFactory
import com.android.tmdb.movie.degea9.ui.main.TopViewModel
import com.android.tmdb.movie.degea9.ui.main.movie.adapter.MovieViewPagerAdapter
import com.android.tmdb.movie.degea9.ui.showdetail.ShowDetailActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: TmdbViewModelFactory

    lateinit var topViewModel: TopViewModel
    lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.setLifecycleOwner(viewLifecycleOwner)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vp_movies.adapter = MovieViewPagerAdapter(childFragmentManager)
        tabs.setupWithViewPager(vp_movies)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        topViewModel = ViewModelProviders.of(this, viewModelFactory).get(TopViewModel::class.java)
//        rv_in_theaters.layoutManager = GridLayoutManager(this.context, 1)
//        rv_on_tv.layoutManager = GridLayoutManager(this.context, 1)
//
//        topViewModel.broadcastingShows.observe(viewLifecycleOwner, Observer {
//            rv_on_tv.adapter = OnTvAdapter(it) {
//                navigateToDetail(it.id)
//            }
//
//        })
//
//        topViewModel.onTheaterMovies.observe(viewLifecycleOwner, Observer {
//            rv_in_theaters.adapter = InTheatersAdapter(it)
//        })
    }

    fun navigateToDetail(id:Int) {
        //findNavController(this).navigate(R.id.action_mainFragment_to_showDetailFragment)
        val intent = Intent(context, ShowDetailActivity::class.java)
        intent.putExtra(ShowDetailActivity.EXTRA_TVSHOW_ID,id)
        startActivity(intent)
    }

}
