package com.example.substestapplication.ui.movie.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.substestapplication.R
import com.example.substestapplication.databinding.ItemMovieListBinding
import com.example.substestapplication.domain.Movie


/**
 * Adapter to display a list of movies
 */
class MovieAdapter(private val onMovieClicked: (Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    private val movieList = ArrayList<Movie>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_movie_list, parent, false))


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }


    override fun getItemCount() = movieList.size


    fun setMovies(movies: List<Movie>) {
        movieList.run {
            clear()
            addAll(movies)
        }
        notifyDataSetChanged()
    }


    inner class MovieViewHolder(private val dataBinding: ItemMovieListBinding) : RecyclerView.ViewHolder(dataBinding.root) {

        fun bind(movie: Movie) {
            dataBinding.run {
                this.movie = movie
                executePendingBindings()
            }
            itemView.setOnClickListener {
                onMovieClicked.invoke(movie)
            }
        }
    }
}
