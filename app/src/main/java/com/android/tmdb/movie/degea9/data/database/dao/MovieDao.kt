package movietube.tuandang.android.com.movietube.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import movietube.tuandang.android.com.movietube.db.entity.Movie

@Dao
interface MovieDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(repositories: List<Movie>)

    @Query(
            """
        SELECT * FROM Movie
        ORDER BY popularity DESC"""
    )
    abstract fun loadPopularMovies(): LiveData<List<Movie>>

}