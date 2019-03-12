package movietube.tuandang.android.com.movietube.db.entity

import androidx.room.Entity
import androidx.room.Index
import com.google.gson.annotations.SerializedName

@Entity(indices = [Index("id")],primaryKeys = ["id"])
data class Movie(
        @SerializedName("id")
        val id:Int,
        @SerializedName("title")
        val title:String,
        @SerializedName("poster_path")
        val posterUrl : String,
        @SerializedName("popularity")
        val popularity:Float

)
