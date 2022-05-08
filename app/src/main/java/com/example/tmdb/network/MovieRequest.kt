package com.example.tmdb.network

import com.example.tmdb.data.MovieList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

object MovieRequest {

    suspend fun requestMovie(page: Int): MovieList? {
        val baseUrl = "https://api.themoviedb.org/3/discover/"
        val apiKey = "4a9eaa647cb60779c9d312baf95bff34"

        val moviesRequest = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequests::class.java)

        Timber.i("Starting coroutines of page $page")
        return coroutineScope {
            (Dispatchers.IO)
            val response = moviesRequest.getMovies(apiKey = apiKey, page = page).awaitResponse()
            if (response.isSuccessful) {
                return@coroutineScope response.body()!!
            } else {
                Timber.i("error in request page $page. error: ${response.errorBody()}")
                null
            }
        }
    }
}