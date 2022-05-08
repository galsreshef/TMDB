package com.example.tmdb.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tmdb.adapters.MovieAdapter
import com.example.tmdb.databinding.FragmentFeedBinding
import com.example.tmdb.viewmodel.FeedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

/**
 * Created by Gal Reshef on 5/5/2022.
 */

@AndroidEntryPoint
class Feed : Fragment() {
    private lateinit var binding: FragmentFeedBinding
    private  val viewModel : FeedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        val adapter = MovieAdapter()
        binding.rvMovies.adapter = adapter


        lifecycleScope.launchWhenStarted {
            viewModel.movieList.collectLatest {
                Timber.i("collected from flow movieList")
                adapter.submitList(it)
            }
        }

        return binding.root
    }
}
