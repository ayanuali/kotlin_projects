package com.udacity.shoestore.screens.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    lateinit var binding: ShoeDetailFragmentBinding
    lateinit var activityViewModel: ActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)
        activityViewModel = ViewModelProvider(activity!!).get(ActivityViewModel::class.java)
        binding.viewModel = activityViewModel
        binding.lifecycleOwner = this
        binding.cancel.setOnClickListener {
            findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoesListFragment()
            )
        }

        binding.save.setOnClickListener {
            //get shoe details from view
            if (binding.shoeName.text.isEmpty() || binding.shoeName.text.isBlank()) {
                Toast.makeText(
                    context,
                    "Name is empty", Toast.LENGTH_SHORT
                ).show()
            } else if (binding.shoeSize.text.isEmpty() || binding.shoeSize.text.isBlank()) {
                Toast.makeText(
                    context,
                    "Size is empty", Toast.LENGTH_SHORT
                ).show()
            } else if (binding.shoeCompany.text.isEmpty() || binding.shoeCompany.text.isBlank()) {
                Toast.makeText(
                    context,
                    "Company is empty", Toast.LENGTH_SHORT
                ).show()
            } else if (binding.shoeDescription.text.isEmpty() || binding.shoeDescription.text.isBlank()) {
                Toast.makeText(
                    context,
                    "Description is empty", Toast.LENGTH_SHORT
                ).show()
            } else {
                val shoe = Shoe(
                    binding.shoeName.text.trim().toString(),
                    binding.shoeSize.text.trim().toString()
                        .toDouble(),
                    binding.shoeCompany.text.trim().toString(),
                    binding.shoeDescription.text.trim().toString()
                )

                activityViewModel.addShoeToShoesList(shoe)
                findNavController().navigate(
                    ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoesListFragment()
                        .setShoeAdded(true)
                )
            }
        }
        return binding.root
    }
}