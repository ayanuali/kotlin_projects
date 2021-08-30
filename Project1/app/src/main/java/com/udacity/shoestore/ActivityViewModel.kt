package com.udacity.shoestore

import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ActivityViewModel : ViewModel() {
    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    var shoeName = MutableLiveData<String>()
    var shoeSize = MutableLiveData<String>()
    var shoeCompany = MutableLiveData<String>()
    var shoeDesc = MutableLiveData<String>()

    init {
        Timber.i("ActivityViewModel initialized")
        _shoesList.value = mutableListOf()
    }

    fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }

    fun addShoeToShoesList(shoe: Shoe) {
        _shoesList.value?.add(shoe)
        _shoesList.value = _shoesList.value
    }
}