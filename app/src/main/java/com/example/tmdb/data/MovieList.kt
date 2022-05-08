package com.example.tmdb.data

class MovieList(
    val results: List<Result>,
)

data class Result(
    val genre_ids: List<Int>,
    val id: Int,
    val release_date: String,
    val title: String
)