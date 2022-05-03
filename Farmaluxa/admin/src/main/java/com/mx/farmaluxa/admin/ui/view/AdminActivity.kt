package com.mx.farmaluxa.admin.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mx.farmaluxa.admin.databinding.ActivityAdminBinding

class AdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}