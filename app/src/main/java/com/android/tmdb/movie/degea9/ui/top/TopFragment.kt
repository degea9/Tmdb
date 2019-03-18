package com.android.tmdb.movie.degea9.ui.top


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.databinding.FragmentMainBinding
import com.android.tmdb.movie.degea9.ui.top.adapter.OnTvAdapter
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
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, container, false)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this
        rv_on_tv.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        //adapter = OnTvAdapter(emptyList())
        //rv_on_tv.adapter = adapter
        topViewModel = ViewModelProviders.of(this, viewModelFactory).get(TopViewModel::class.java)
//        topViewModel.broadcastingShows.observe(viewLifecycleOwner, Observer {
//            Log.e("degea9", "tvshow on the air size " + it.size)
//            rv_on_tv.adapter = OnTvAdapter(it)
//            //adapter.setData(it)
//            //adapter.notifyDataSetChanged()
//        })
        binding.topViewModel = topViewModel
    }

}
