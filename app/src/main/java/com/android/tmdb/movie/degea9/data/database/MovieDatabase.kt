package movietube.tuandang.android.com.movietube.db

import androidx.room.Database
import androidx.room.RoomDatabase
import movietube.tuandang.android.com.movietube.db.dao.MovieDao
import movietube.tuandang.android.com.movietube.db.entity.Movie

@Database(entities = [Movie::class],version = 1,exportSchema = false)
abstract class MovieDatabase: RoomDatabase(){
    abstract fun movieDao():MovieDao
}