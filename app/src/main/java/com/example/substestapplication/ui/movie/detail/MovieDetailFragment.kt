package com.example.substestapplication.ui.movie.detail

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.substestapplication.R
import com.example.substestapplication.domain.Movie
import com.example.substestapplication.ui.base.BaseFragment
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.substestapplication.databinding.FragmentMovieDetailBinding


/**
 * Fragment that displays movie detail
 */
class MovieDetailFragment : BaseFragment<MovieDetailViewModel>() {


    companion object {

        private const val MOVIE = "movie"

        fun newInstance(movie: Movie) = MovieDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MOVIE, movie)
            }
        }
    }


    override val viewModel: MovieDetailViewModel by viewModel {
        parametersOf(arguments!!.getParcelable(MOVIE))
    }
    private lateinit var menuFav: MenuItem


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return DataBindingUtil.inflate<FragmentMovieDetailBinding>(inflater, R.layout.fragment_movie_detail, container, false).apply {
            lifecycleOwner = this@MovieDetailFragment
            viewModel = this@MovieDetailFragment.viewModel
        }.root
    }

    private fun observeData() {
        viewModel.showMovieFavorite.observe(this, Observer {
            if (::menuFav.isInitialized) {
                menuFav.icon = ContextCompat.getDrawable(
                    requireContext(),
                    if (it) R.drawable.ic_favorite else R.drawable.ic_favorite_border
                )
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.movie_detail_menu, menu)
        menuFav = menu.findItem(R.id.action_fav)
        // Start observing data here to make sure menuFav is initialized
        observeData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = if (item.itemId == R.id.action_fav) {
        viewModel.onFavClicked()
        true
    } else {
        super.onOptionsItemSelected(item)
    }

}