package com.example.substestapplication.ui.movie.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.substestapplication.R
import com.example.substestapplication.databinding.FragmentMovieListContainerBinding
import com.example.substestapplication.ui.movie.list.favorite.FavoriteMovieListFragment
import com.example.substestapplication.ui.movie.list.popular.PopularMovieListFragment
import java.security.InvalidParameterException


/**
 * Fragment that shows @see PopularMovieListFragment and @see FavoriteMovieListFragment depending on
 * a @see BottomNavigationView
 */
class MovieListContainerFragment : Fragment() {


    companion object {
        private const val POPULAR_POSITION = 0
        private const val FAVORITES_POSITION = 1
    }


    private lateinit var binding: FragmentMovieListContainerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list_container, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.run {
            adapter = ContainerListPagerAdapter(requireFragmentManager())
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            val position = if (it.itemId == R.id.menu_populars) POPULAR_POSITION else FAVORITES_POSITION
            binding.viewPager.currentItem = position
            true
        }
    }

    class ContainerListPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int) = when (position) {
            POPULAR_POSITION -> PopularMovieListFragment.newInstance()
            FAVORITES_POSITION -> FavoriteMovieListFragment.newInstance()
            else -> throw InvalidParameterException("Position $position is not valid")
        }

        override fun getCount() = 2

    }

}