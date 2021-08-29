package com.udacity.shoestore.screens.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoesListFragmentBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoesListFragment : Fragment() {
    lateinit var binding: ShoesListFragmentBinding
    private val args: ShoesListFragmentArgs by navArgs<ShoesListFragmentArgs>()
    lateinit var activityViewModel: ActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoes_list_fragment, container, false)

        val shoeAdded = args.shoeAdded
        Timber.i("shoes shoeAdded $shoeAdded")

        activityViewModel = ViewModelProvider(activity!!).get(ActivityViewModel::class.java)

        if(shoeAdded) {
//            val shoe = Shoe("testname", 12.00, "testcompany", "testdescription")
//            activityViewModel.addShoeToShoesList(shoe)
        }
        activityViewModel.shoesList.observe(viewLifecycleOwner, Observer {
            Timber.i("shoes shoeList $it")
            Timber.i("shoes shoeList size ${it.size}")
        })

        binding.addShoe.setOnClickListener {
            val action = ShoesListFragmentDirections.actionShoesListFragmentToShoeDetailFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}