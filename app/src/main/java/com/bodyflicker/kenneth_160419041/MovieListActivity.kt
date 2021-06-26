package com.bodyflicker.kenneth_160419041

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        // Siapkan LayoutManager
        val lm = LinearLayoutManager(this)
//        lm.orientation = LinearLayoutManager.HORIZONTAL
        val glm = GridLayoutManager(this, 2)
        // Staggered grid
        val sg = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        // Pengaturan recycleview
        with(recyclerView) {
            layoutManager = lm
            setHasFixedSize(true)
            adapter = MovieAdapter(applicationContext)
        }
        // Listener fab
        fabNewMovie.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}