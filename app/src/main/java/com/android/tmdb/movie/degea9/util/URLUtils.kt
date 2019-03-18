package movietube.tuandang.android.com.movietube.util

class URLUtils{
    companion object {
        private val BASE_IMAGE_URL = "http://image.tmdb.org/t/p/"
        private val POSTER_SIZE_W342 = "w342"

        fun buildPosterUrl(posterUrl:String?) = BASE_IMAGE_URL+ POSTER_SIZE_W342+posterUrl
    }

}