package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding
import timber.log.Timber
import kotlin.math.log

class LoginFragment : Fragment() {
    private lateinit var binding: LoginFragmentBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginViewModel.isLogin.observe(this, Observer { isLogin ->
            Timber.i("isLogin $isLogin")
            if (isLogin) {
                onLoginFinished()
                loginViewModel.onLoginComplete()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        binding.loginViewModel = loginViewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }


    fun onLoginFinished() {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        findNavController().navigate(action)
    }
}