package com.android.tmdb.movie.degea9.ui.showdetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.data.database.entity.TvShowDetail
import com.android.tmdb.movie.degea9.databinding.FragmentInfoBinding
import kotlinx.android.synthetic.main.fragment_info.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class InfoFragment () : Fragment() {

    lateinit var binding: FragmentInfoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        binding.setLifecycleOwner(viewLifecycleOwner)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel:TvShowDetailViewModel = ViewModelProviders.of(activity!!).get(TvShowDetailViewModel::class.java)
        viewModel.tvShowDetail.observe(viewLifecycleOwner, Observer {
            binding.show = it
        })

    }

}
