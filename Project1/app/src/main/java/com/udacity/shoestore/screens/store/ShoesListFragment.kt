package com.udacity.shoestore.screens.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoesListFragmentBinding

class ShoesListFragment : Fragment() {
    lateinit var binding: ShoesListFragmentBinding
    lateinit var shoesListViewModel: ShoesListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        shoesListViewModel = ViewModelProvider(this).get(ShoesListViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoes_list_fragment, container, false)
        return binding.root
    }
}