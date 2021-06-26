package com.bodyflicker.kenneth_160419041

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_movie_card.view.*

class MovieAdapter(val context: Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_movie_card, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = Global.movies[position]
        with(holder.view) {
            val url = movie.url
            Picasso.get().load(url).into(holder.view.imgPoster)
            txtTitle.text = movie.title
            txtShowDate.text = movie.showDate
            textRating.text = movie.rating
            buttonMore.setOnClickListener {
                val intent = Intent(context, MovieWebActivity::class.java)
                intent.putExtra(Global.EXTRA_IMDB, movie.imdbUrl)
                context.startActivity(intent)
            }
            buttonDelete.setOnClickListener {
                AlertDialog.Builder(context).apply {
                    setMessage("Delete movie ${movie.title}?")
                    setPositiveButton("Delete") { _, _ ->
                        // Hapus dari array list
                        Global.movies.removeAt(position)
                        // Update data di Recycler view
                        this@MovieAdapter.notifyDataSetChanged()
                        Toast.makeText(
                            context,
                            "Movie ${movie.title} has been deleted.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    setNegativeButton("Cancel", null)
                    create().show()
                }
            }
        }
    }

    override fun getItemCount() = Global.movies.size
}