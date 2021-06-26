package com.bodyflicker.kenneth_160419041

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.children
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textNewMovie.text = "New Movie #${Global.movieNumber}"
        // Mengubah gambar ImageView dari resource
        imagePoster.setImageResource(R.drawable.ic_undrawemail)

        // Default selected checkbox
        checkDolby.isChecked = true

        buttonSubmit.setOnClickListener {
            if (editRuntime.text.isNotEmpty()) {
                val time = editRuntime.text.toString().toInt()
                val jam = time / 60
                val menit = time % 60
                Toast.makeText(this, "$jam jam $menit menit", Toast.LENGTH_SHORT).show()
            }
            // Ganti gambar ImageView dari URL dengan Picasso
            val url = editURL.text.toString()
//            Picasso.get().load(url).into(imagePoster)

            val movieTitle = editTextPersonName.text.toString()
            val movieDate = textShowDate.text.toString()
            val movieURL = editURL.text.toString()
            val selected = groupRating.children.find { (it as RadioButton).isChecked } as RadioButton
            val movieRating = selected.text.toString()
            // Tambahkan ke arraylist
            Global.movies.add(Movie(movieTitle, movieRating, movieDate, movieURL, ""))
            Global.movieNumber++
            finish()
        }

        // Listener radio group
        groupRating.setOnCheckedChangeListener { group, id ->
            if (id == R.id.radioEveryone) {
                Toast.makeText(this, "Enjoy with your family", Toast.LENGTH_SHORT).show()
            } else if (id == R.id.radioPG) {
                Toast.makeText(this, "This movie is marked PG", Toast.LENGTH_SHORT).show()
            } else if (id == R.id.radioMature) {
                Toast.makeText(this, "This movie is marked mature", Toast.LENGTH_SHORT).show()
            }

            group.children.forEach {
                it as RadioButton
                it.setTextColor(Color.parseColor(if (it.isChecked) "#eb2f06" else "#000000"))
            }

            for (radio in group.children) {
                radio as RadioButton
                radio.setTextColor(Color.parseColor(if (radio.isChecked) "#eb2f06" else "#000000"))
            }
        }

        // Listener edit text ketika diklik
        // Munculkan datepicker
        textShowDate.setOnClickListener {
            // tanggal hari ini
            var today = Calendar.getInstance()
            var tahun = today.get(Calendar.YEAR)
            var month = today.get(Calendar.MONTH)
            var day = today.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, selYear, selMonth, selDay ->
                    // Listener ketika user selesai memilih tanggal
                    val calendar = Calendar.getInstance()
                    calendar.set(selYear, selMonth, selDay)
                    // Siapin dateformat
                    val dateFormat = SimpleDateFormat("dd MMMM yyyy")
                    val date = dateFormat.format(calendar.time)
                    // Tampilin
                    textShowDate.setText(date)
                }, tahun, month, day
            ).show()
        }

        // Isi spinner
        // Buat adapter
        val adapter = ArrayAdapter(this, R.layout.myspinner_layout, Global.Genres)
        // Atur layout dropdown list
        adapter.setDropDownViewResource(R.layout.myspinner_item_layout)
        // Berikan adapter ke spinner
        spinnerGenre.adapter = adapter

    }

    fun featuresHandler(v: View) {
        with(v as CheckBox) {
            if (id == R.id.checkDolby && isChecked) {
                Toast.makeText(applicationContext, "Loud and clear!", Toast.LENGTH_SHORT).show()
            }
            if (id == R.id.checkAtmos && isChecked) {
                Toast.makeText(applicationContext, "Crystal clear!", Toast.LENGTH_SHORT).show()
            }
            if (id == R.id.check3D && isChecked) {
                Toast.makeText(applicationContext, "Ready your 3D glasses!", Toast.LENGTH_SHORT)
                    .show()
            }
            var studio = ""
            if (checkDolby.isChecked) studio = "Studio 1"
            if (checkAtmos.isChecked) studio = "$studio Studio 2"
            if (check3D.isChecked) studio = "$studio Studio 3"
            studio = studio.trimStart()
            editStudio.setText(studio)
        }
    }

}