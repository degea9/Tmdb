package movietube.tuandang.android.com.movietube.util

class URLUtils{
    companion object {
        private val BASE_IMAGE_URL = "http://image.tmdb.org/t/p/"
        private val SIZE_342_192 = "w342"
        private val SIZE_154_231 = "w154"
        private val SIZE_185_278 = "w185"
        private val SIZE_W_780 = "w780"

        fun buildBackDropUrl(backdropPath:String?) = BASE_IMAGE_URL+ SIZE_W_780+backdropPath

        fun buildPosterUrl(posterPath:String?) = BASE_IMAGE_URL+SIZE_185_278+posterPath

        fun buildProfileUrl(profilePath:String?) = BASE_IMAGE_URL+SIZE_185_278+profilePath
    }

}