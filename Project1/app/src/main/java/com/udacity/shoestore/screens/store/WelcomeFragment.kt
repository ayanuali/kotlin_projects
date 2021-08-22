package com.udacity.shoestore.screens.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    lateinit var binding: WelcomeFragmentBinding
    lateinit var welcomeViewModel: WelcomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        welcomeViewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)

        welcomeViewModel.isOnGetStarted.observe(this, Observer { isOnGetStarted ->
            if (isOnGetStarted) {
                onGetStartedEvent()
                welcomeViewModel.onGetStartedComplete()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false)
        //view model binding
        binding.welcomViewModel = welcomeViewModel
        return binding.root
    }

    fun onGetStartedEvent() {
        //actions from welcome to instructions
        val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
        findNavController().navigate(action)
    }
}