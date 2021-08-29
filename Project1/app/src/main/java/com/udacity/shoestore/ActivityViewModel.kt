package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ActivityViewModel : ViewModel() {
    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    init {
        Timber.i("ActivityViewModel initialized")
        _shoesList.value = mutableListOf()
    }

    fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }

    fun addShoeToShoesList(shoe: Shoe) {
        Timber.i("shoeList shoe $shoe")
        _shoesList.value?.add(shoe)
        Timber.i("shoeList _shoesList.value ${_shoesList.value}")
        _shoesList.value = _shoesList.value
    }
}