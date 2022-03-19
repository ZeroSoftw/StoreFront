package com.mx.farmaluxa.login.ui.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mx.farmaluxa.login.R
import com.mx.farmaluxa.login.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var bindin : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
}