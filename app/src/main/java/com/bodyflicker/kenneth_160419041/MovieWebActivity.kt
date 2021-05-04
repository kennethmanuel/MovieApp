package com.bodyflicker.kenneth_160419041

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_movie_web.*

class MovieWebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_web)

        val url = intent.getStringExtra(Global.EXTRA_IMDB)
        with(webView) {
            webViewClient = WebViewClient()
            loadUrl(url.toString())
            settings.javaScriptEnabled = true
        }
    }
}