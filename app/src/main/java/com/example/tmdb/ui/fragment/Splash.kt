package com.example.tmdb.ui.fragment

import android.animation.Animator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tmdb.BuildConfig
import com.example.tmdb.R
import com.example.tmdb.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class Splash : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSplashBinding.inflate(inflater, container, false)
        binding.tvAppVersion.text = String.format(getString(R.string.version),
            BuildConfig.VERSION_NAME
        )
        binding.lottie.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                Timber.i("onAnimationStart") }

            override fun onAnimationEnd(animation: Animator?) {
                findNavController().navigate(R.id.action_splash_to_feed)
                Timber.i("No user navigating to Login")
            }
            override fun onAnimationCancel(animation: Animator?) {
                Timber.i("onAnimationCancel") }

            override fun onAnimationRepeat(animation: Animator?) {
                Timber.i("onAnimationRepeat") }
        })
        return binding.root
    }
}