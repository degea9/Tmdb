package com.android.tmdb.movie.degea9.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.tmdb.movie.degea9.data.database.entity.TVShow

@Dao
interface TVShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertTVShows(repositories: List<TVShow>)

    @Query(
        """
        SELECT * FROM TVShow ORDER BY popularity DESC"""
    )
    abstract fun loadPopularMovies(): LiveData<List<TVShow>>

}