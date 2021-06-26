package com.bodyflicker.kenneth_160419041

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_movie_card.*

class MovieCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_card)
        var movieTitle = intent.getStringExtra(Global.MOVIE_TITLE)
        var movieDate = intent.getStringExtra(Global.SHOW_DATE)
        var movieURL = intent.getStringExtra(Global.POSTER_URL)
        var movieRating = intent.getStringExtra(Global.RATING)

        Log.d("check intent", movieTitle.toString())

        txtTitle.setText(movieTitle)
        txtShowDate.setText(movieDate)
        textRating.text = movieRating
    }

}