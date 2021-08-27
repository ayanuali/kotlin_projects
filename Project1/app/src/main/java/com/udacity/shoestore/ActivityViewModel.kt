package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ActivityViewModel : ViewModel() {
    private val _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList: LiveData<List<Shoe>>
        get() = _shoesList

    init {
        Timber.i("ActivityViewModel initialized")
        _shoesList.value = listOf()
    }

    fun addShoeToShoesList(shoe: Shoe) {
        val list = listOf<Shoe>()
        if (_shoesList.value != null) {
            list.plus(_shoesList.value!!)
        }
        list.plus(shoe)
        _shoesList.value = list
    }
}