package com.example.substestapplication.ui.movie.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.substestapplication.R
import com.example.substestapplication.domain.Movie
import kotlinx.android.synthetic.main.activity_detail.*


/**
 * Activity to display movie detail
 */
class MovieDetailActivity : AppCompatActivity() {

    companion object {

        private const val MOVIE = "movie"

        fun newInten(context: Context, movie: Movie): Intent = Intent(context, MovieDetailActivity::class.java).apply {
            putExtra(MOVIE, movie)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        title = null

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MovieDetailFragment.newInstance(intent!!.getParcelableExtra(MOVIE)!!))
            .commitNow()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}