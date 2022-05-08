package com.example.tmdb.util

/**
 * Created by Gal Reshef on 5/5/2022.
 */

object Extensions {

    fun genreFactor(list: List<Int>): List<String> {
        val arr = arrayListOf<String>()
        for (genre in list) {
            arr.add(
                when (genre) {
                    28 -> "Action"
                    12 -> "Adventure"
                    16 -> "Animation"
                    35 -> "Comedy"
                    80 -> "Crime"
                    99 -> "Documentary"
                    18 -> "Drama"
                    10751 -> "Family"
                    14 -> "Fantasy"
                    36 -> "Adventure"
                    27 -> "Horror"
                    10402 -> "Music"
                    9648 -> "Mystery"
                    10749 -> "Romance"
                    878 -> "Science Fiction"
                    10770 -> "TV Movie"
                    53 -> "Thriller"
                    10752 -> "War"
                    37 -> "Western"
                    else -> {
                        "New Genre"
                    }
                }
            )
        }
        return arr
    }
}

