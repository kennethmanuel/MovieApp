package com.bodyflicker.kenneth_160419041

object Global {
    var movieNumber = 1
    val MOVIE_TITLE = "movietitle"
    val SHOW_DATE = "showdate"
    val POSTER_URL = "posterurl"
    val RATING = "ratign"
    val Genres: Array<Genre> = arrayOf(
        Genre(1, "Action"),
        Genre(2, "Anime"),
        Genre(3, "Comedies"),
        Genre(4, "Crime"),
        Genre(5, "Dramas"),
        Genre(6, "History"),
        Genre(7, "Horror"),
        Genre(8, "Kids"),
        Genre(9, "Romance"),
        Genre(10, "SciFi & Fantasy"),
        Genre(11, "Thriller")
    )
    val EXTRA_IMDB = "imdb"
    val movies:ArrayList<Movie> = ArrayList(
        listOf(
            Movie("Interstellar", "General", "20 Sept 2020","https://live.staticflickr.com/737/32640476365_906f64ce29_b.jpg","https://www.imdb.com/title/tt0816692/"),
            Movie("Gravity", "General", "13 Sept 2020","https://all-things-andy-gavin.com/wp-content/uploads/2013/10/gravity-movie.jpg", "https://www.imdb.com/title/tt1454468/"),
            Movie("Alien Covenant", "Mature", "06 Sept 2020","https://www.willitsnews.com/wp-content/uploads/migration/2017/201706/NEWS_170609993_AR_0_RALMFSWTQIMI.jpg","https://www.imdb.com/title/tt2316204/"),
            Movie("The Martian", "Parental Guidance", "01 Sept 2020","https://gortoncenter.org/wp-content/uploads/2018/05/The-Martian.jpg","https://www.imdb.com/title/tt3659388/"),
            Movie("2001: A Space Odyssey", "Parental Guidance", "23 August 2020","https://live.staticflickr.com/737/32640476365_906f64ce29_b.jpg","https://www.imdb.com/title/tt0062622/"),
            Movie("Contact", "General", "05 August 2020","https://www.denofgeek.com/wp-content/uploads/2013/06/contact_lead.jpg","https://www.imdb.com/title/tt0118884/"),
            Movie("Apollo 13", "General", "01 August 2020","https://cdn.ticketsource.co.uk/images/promoter/banner/03011-1563478616654.jpg","https://www.imdb.com/title/tt0112384/"),
            Movie("Arrival", "General", "27 July 2020","https://s.studiobinder.com/wp-content/uploads/2010/03/Arrival-Video-Essay-How-to-Balance-Fear-and-Intrigue-WP.jpg","https://www.imdb.com/title/tt2543164/")
        )
    )

}