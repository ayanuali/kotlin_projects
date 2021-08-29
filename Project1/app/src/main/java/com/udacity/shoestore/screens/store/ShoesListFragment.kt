package com.udacity.shoestore.screens.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginTop
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
//        Timber.i("shoes shoeAdded $shoeAdded")

        activityViewModel = ViewModelProvider(activity!!).get(ActivityViewModel::class.java)

        activityViewModel.shoesList.observe(viewLifecycleOwner, Observer {
            for (shoe in it) {
                val shoeItem: LinearLayout = LinearLayout(context)
                val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(16, 16, 16, 16)
                shoeItem.layoutParams = params
                shoeItem.orientation = LinearLayout.VERTICAL

                val params1 = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params1.setMargins(0, 8, 0, 8)

                val shoeName: TextView = TextView(context)
                shoeName.layoutParams = params1
                shoeName.setText("Name: ${shoe.name}")

                shoeItem.addView(shoeName)

                val shoeSize: TextView = TextView(context)
                shoeSize.layoutParams = params1
                shoeSize.setText("Size: ${shoe.size}")

                shoeItem.addView(shoeSize)

                val shoeCompany: TextView = TextView(context)
                shoeCompany.layoutParams = params1
                shoeCompany.setText("Company: ${shoe.company}")

                shoeItem.addView(shoeCompany)

                val shoeDesc: TextView = TextView(context)
                shoeDesc.layoutParams = params1
                shoeDesc.setText("Description: ${shoe.description}")

                shoeItem.addView(shoeDesc)

                binding.shoeList.addView(shoeItem, 0)
                binding.shoeList.invalidate()
            }
        })

        binding.addShoe.setOnClickListener {
            val action = ShoesListFragmentDirections.actionShoesListFragmentToShoeDetailFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}