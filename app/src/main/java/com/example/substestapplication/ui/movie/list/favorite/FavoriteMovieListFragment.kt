package com.example.substestapplication.ui.movie.list.favorite

import com.example.substestapplication.ui.movie.list.base.MovieListBaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * Fragment to display a list of favorited movies
 */
class FavoriteMovieListFragment : MovieListBaseFragment<FavoriteMovieListViewModel>() {

    companion object {
        fun newInstance() = FavoriteMovieListFragment()
    }

    override val viewModel: FavoriteMovieListViewModel by viewModel()

}