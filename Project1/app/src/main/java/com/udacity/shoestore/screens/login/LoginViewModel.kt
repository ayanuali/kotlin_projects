package com.udacity.shoestore.screens.login

import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel : ViewModel() {
    init {
        Timber.i("LoginViewModel created")
    }

    fun onLogin() {
        Timber.i("onLogin clicked")
    }

    fun onSignUp() {
        Timber.i("onSingUp clicked")
    }
}