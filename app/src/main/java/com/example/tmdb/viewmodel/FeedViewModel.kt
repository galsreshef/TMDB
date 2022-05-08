package com.example.tmdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdb.network.MovieRequest
import com.example.tmdb.data.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Gal Reshef on 5/5/2022.
 */

@HiltViewModel
class FeedViewModel @Inject constructor(): ViewModel() {

    private var list: MutableList<Movie> = arrayListOf()
    private val _movieList = MutableSharedFlow<List<Movie>>()
    val movieList: SharedFlow<List<Movie>>
        get() = _movieList

    init {
        Timber.i("Main Feed ViewModel init")
        getMovies(1)
    }

    private fun getMovies(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val movieObject = MovieRequest.requestMovie(1)
            if (movieObject != null) {
                for (i in 1..19) {
                    val movie = Movie()
                    movie.id = movieObject.results[i].id.toString()
                    movie.title = movieObject.results[i].title
                    movie.releaseDate = movieObject.results[i].release_date
                    movie.genre = movieObject.results[i].genre_ids
                    Timber.i("item number ${list.size} is:\n${movie.title}")
                    list.add(movie)
                    if (list.size == 100)
                        break
                }

                if (page < 6) {
                    getMovies(page + 1)
                } else {
                    if (list.isNotEmpty()) {
                        withContext(Dispatchers.Main) {
                            _movieList.emit(list)
                        }
                    }

                }
            }
        }
    }
}