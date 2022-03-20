package com.mx.farmaluxa.login.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.farmaluxa.login.R
import com.mx.farmaluxa.login.ui.view.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.showLoginView()
    }

    private fun showLoginView() {
        val fragmentManager = this.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.mainContainerNav, LoginFragment.newInstance() )
        transaction.commit()
    }
}