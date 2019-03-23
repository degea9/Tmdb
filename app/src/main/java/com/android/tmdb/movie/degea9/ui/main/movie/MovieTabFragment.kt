package com.android.tmdb.movie.degea9.ui.main.movie


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.ui.main.TmdbViewModelFactory
import com.android.tmdb.movie.degea9.ui.main.movie.adapter.TabMovieAdapter
import com.android.tmdb.movie.degea9.ui.moviedetail.MovieDetailActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movie_tab.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass display now playing movies
 *
 */
class MovieTabFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: TmdbViewModelFactory
    lateinit var movieViewModel: MovieViewModel

    companion object {
        fun newInstance(category: Int): MovieTabFragment {
            val bundle = Bundle()
            bundle.putInt("category", category)
            val fragment = MovieTabFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_tab, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_movie.layoutManager = GridLayoutManager(this.context, 1)
        rv_movie.addItemDecoration(
            DividerItemDecoration(
                context!!,
                DividerItemDecoration.VERTICAL
            )
        )
        movieViewModel = ViewModelProviders.of(parentFragment!!, viewModelFactory).get(MovieViewModel::class.java)

        val category = arguments?.getInt("category")


        movieViewModel.getMovies(category!!).observe(viewLifecycleOwner, Observer {
            swipe_fresh.isRefreshing = false
            rv_movie.adapter = TabMovieAdapter(it) {
                navigateToDetail(it.id)
            }
        })

        movieViewModel.getLoadingStatus(category!!)?.observe(viewLifecycleOwner, Observer {
            progressbar.visibility = if (it) View.VISIBLE else View.GONE
        })

        //        movieViewModel.error.observe(viewLifecycleOwner, Observer {
//            Log.e("tuandang","error "+it)
//        })

        swipe_fresh.setOnRefreshListener {
            movieViewModel.reFresh(category)
        }
    }

    private fun navigateToDetail(movieId:Int){
        val intent = Intent(context,MovieDetailActivity::class.java)
        intent.putExtra(MovieDetailActivity.EXTRA_MOVIE_ID,movieId)
        startActivity(intent)
    }

}
