package com.udacity.shoestore.screens.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class WelcomeViewModel : ViewModel() {
    private val _isOnGetStarted = MutableLiveData<Boolean>()
    val isOnGetStarted: LiveData<Boolean>
        get() = _isOnGetStarted

    init {
        Timber.i("Welcome View Model initiated")
        _isOnGetStarted.value = false
    }

    fun onGetStarted() {
        Timber.i("onGetStarted trigerred")
        _isOnGetStarted.value = true
    }

    fun onGetStartedComplete() {
        Timber.i("onGetStartedComplete called")
        _isOnGetStarted.value = false
    }
}