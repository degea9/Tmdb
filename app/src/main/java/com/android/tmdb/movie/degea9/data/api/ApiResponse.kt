package movietube.tuandang.android.com.movietube.api

import com.google.gson.annotations.SerializedName
import movietube.tuandang.android.com.movietube.db.entity.Movie

data class ApiResponse(
        @SerializedName("page")
        val page:Int,
        @SerializedName("results")
        val movies:List<Movie>

)