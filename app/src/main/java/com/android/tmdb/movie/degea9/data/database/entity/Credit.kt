package com.android.tmdb.movie.degea9.data.database.entity

import com.android.tmdb.movie.degea9.data.api.DataResponse

data class Credit(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int?
):DataResponse<Credit> {
    override fun retrieveData(): Credit = this
}