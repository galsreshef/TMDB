package com.example.tmdb.network

import com.example.tmdb.data.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Gal Reshef on 5/5/2022.
 */
interface ApiRequests {

    @GET("movie")
    fun getMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int,
        @Query("primary_release_date.gte") startDate: String = "2014-01-01",
        @Query("primary_release_date.lte") endDate: String = "2014-12-31"
    ): Call<MovieList>

}