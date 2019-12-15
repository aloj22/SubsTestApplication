package com.example.substestapplication.ui.movie.list.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.substestapplication.R
import com.example.substestapplication.databinding.FragmentMovieListBinding
import com.example.substestapplication.domain.Movie
import com.example.substestapplication.ui.base.BaseFragment
import com.example.substestapplication.ui.movie.detail.MovieDetailActivity
import com.example.substestapplication.ui.movie.list.MovieAdapter


/**
 * Base fragment that manages @see MovieListBaseViewModel events to display a list of movies
 */
@Suppress("MemberVisibilityCanBePrivate")
abstract class MovieListBaseFragment<T : MovieListBaseViewModel> : BaseFragment<T>() {


    protected lateinit var binding: FragmentMovieListBinding
    protected val adapter = MovieAdapter(::onMovieClicked)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)
        binding.run {
            lifecycleOwner = this@MovieListBaseFragment
            viewModel = this@MovieListBaseFragment.viewModel
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeData()
    }

    private fun initViews() {
        binding.moviesRecyclerView.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@MovieListBaseFragment.adapter
        }
    }

    private fun observeData() {
        viewModel.addMovies.observe(this, Observer {
            adapter.setMovies(it)
        })
    }


    protected fun onMovieClicked(movie: Movie) {
        startActivity(MovieDetailActivity.newInten(requireContext(), movie))
    }

}