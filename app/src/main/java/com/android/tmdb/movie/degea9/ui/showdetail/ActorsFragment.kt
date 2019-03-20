package com.android.tmdb.movie.degea9.ui.showdetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.ui.showdetail.adapter.ActorAdapter
import kotlinx.android.synthetic.main.fragment_actors.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ActorsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actors, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_actors.layoutManager = GridLayoutManager(context,1)
        val viewModel = ViewModelProviders.of(activity!!).get(TvShowDetailViewModel::class.java)
        viewModel.credit.observe(viewLifecycleOwner, Observer {
            rv_actors.adapter = ActorAdapter(it.cast)
        })
    }
}
