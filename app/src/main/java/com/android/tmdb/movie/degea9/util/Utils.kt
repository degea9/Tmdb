package com.android.tmdb.movie.degea9.util

import com.android.tmdb.movie.degea9.data.database.entity.MovieDetail
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class Utils {

    companion object {
        fun convertRuntime(movieDetail: MovieDetail): String {
            return extractYear(movieDetail.release_date) + " • " + convertMinutesToHours(movieDetail.runtime)
        }

        fun convertMinutesToHours(minutes: Int): String {
            val hours = TimeUnit.MINUTES.toHours(minutes.toLong())
            val remainMinutes = minutes - TimeUnit.HOURS.toMinutes(hours)
            return "$hours hrs $remainMinutes mins"
        }

        fun extractYear(string: String): String {
            val format = SimpleDateFormat("yyyy-mm-dd", Locale.US)
            val cal = Calendar.getInstance();
            cal.time = format.parse(string)
            return cal.get(Calendar.YEAR).toString()
        }

        fun findCertification(iso_3166_1:String,movieDetail: MovieDetail):String?{
            return movieDetail.release_dates.results.findLast { iso_3166_1.equals(it.iso_3166_1) }?.release_dates?.first()?.certification
        }
    }
}