package com.udacity.shoestore.screens.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoesListFragmentBinding

class ShoesListFragment : Fragment() {
    lateinit var binding: ShoesListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoes_list_fragment, container, false)
        binding.addShoe.setOnClickListener {
            val action = ShoesListFragmentDirections.actionShoesListFragmentToShoeDetailFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}