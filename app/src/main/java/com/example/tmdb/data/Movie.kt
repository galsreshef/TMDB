package com.example.tmdb.data

import java.io.Serializable

class Movie : Serializable {
    var id: String? = null
    var genre: List<Int>? = null
    var title: String? = null
    var releaseDate: String? = null
}