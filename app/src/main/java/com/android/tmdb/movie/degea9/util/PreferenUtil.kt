package com.android.tmdb.movie.degea9.util

import android.content.Context
import android.R.id.edit
import android.content.SharedPreferences



class PreferenUtil private constructor(val context: Context) {
    private lateinit var sharedPreferences:SharedPreferences
    init {
         sharedPreferences=context.getSharedPreferences("info",Context.MODE_PRIVATE);
    }
//    companion object {
//        @Volatile
//        private var instance: PreferenUtil? = null
//
//        fun getInstance(
//            context: Context
//        ): PreferenUtil = instance ?: synchronized(this) {
//            instance ?: PreferenUtil(context).also { instance = it }
//        }
//    }

    fun getString(key: String): String {
        return sharedPreferences.getString(key, "")
    }

    fun setString(key: String, values: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, values)
        editor.commit()
    }
}