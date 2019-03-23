package com.android.tmdb.movie.degea9.util

import com.android.tmdb.movie.degea9.data.database.entity.Genre
import com.android.tmdb.movie.degea9.data.database.entity.TvShowDetail


class GenreUtils {


    companion object {
        val movieGenreMap by lazy {
            HashMap<Int, String>().apply {
                putGenre(Genre(28, "Action"))
                putGenre(Genre(12, "Adventure"))
                putGenre(Genre(16, "Animation"))
                putGenre(Genre(35, "Comedy"))
                putGenre(Genre(80, "Crime"))
                putGenre(Genre(99, "Documentary"))
                putGenre(Genre(18, "Drama"))
                putGenre(Genre(10751, "Family"))

                putGenre(Genre(14, "Fantasy"))
                putGenre(Genre(36, "History"))
                putGenre(Genre(27, "Horror"))
                putGenre(Genre(10402, "Music"))
                putGenre(Genre(9648, "Mystery"))
                putGenre(Genre(10749, "Romance"))
                putGenre(Genre(878, "Science Fiction"))
                putGenre(Genre(10770, "TV Movie"))

                putGenre(Genre(53, "Thriller"))
                putGenre(Genre(10752, "War"))
                putGenre(Genre(37, "Western"))
            }
        }

        fun HashMap<Int, String>.putGenre(genre: Genre) {
            put(genre.id, genre.name)
        }
    }


}