package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel : ViewModel() {
    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean>
        get() = _isLogin

    init {
        Timber.i("LoginViewModel trigerred")
        _isLogin.value = false
    }

    fun onLogin() {
        Timber.i("onLogin trigerred")
        _isLogin.value = true
    }

    fun onLoginComplete() {
        Timber.i("onLoginComplete trigerred")
        _isLogin.value = false
    }

    fun onSignUp() {
        Timber.i("onSingUp clicked")
    }
}