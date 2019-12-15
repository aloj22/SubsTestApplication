package com.example.substestapplication.ui.movie.list.popular

import com.example.substestapplication.ui.movie.list.base.MovieListBaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * Fragment to display a list of popular movies
 */
class PopularMovieListFragment : MovieListBaseFragment<PopularMovieListViewModel>() {


    companion object {
        fun newInstance() = PopularMovieListFragment()
    }


    override val viewModel: PopularMovieListViewModel by viewModel()


}
