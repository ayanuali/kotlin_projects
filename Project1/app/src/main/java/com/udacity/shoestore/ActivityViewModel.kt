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
        val list = mutableListOf<Shoe>()
        if (_shoesList.value != null && _shoesList.value!!.isNotEmpty()) {
            list.addAll(_shoesList.value!!)
        }
        list.add(shoe)
        Timber.i("shoeList list $list")
//        _shoesList.value?.add(shoe)
        Timber.i("shoeList _shoesList.value ${_shoesList.value}")
        _shoesList.value?.addAll(list)
        Timber.i("shoeList after _shoesList.value ${_shoesList.value}")
    }
}