package com.mx.farmaluxa.warehouse.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mx.farmaluxa.warehouse.R
import com.mx.farmaluxa.warehouse.databinding.ActivityWarehouseBinding

class WarehouseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWarehouseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWarehouseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        this.configureToolBar()
    }

    private fun configureToolBar() {
        val navHostFragment =
            this.supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                    as NavHostFragment

        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph, this.binding.drawerLayout)
        this.binding.iHeaderLayout.toolbar.setupWithNavController(navController, appBarConfiguration)

        this.binding.iHeaderLayout.toolbar.title = getString(com.mx.farmaluxa.sharedutil.R.string.app_name)
        this.binding.iHeaderLayout.tvTitle.text = getString(R.string.str_title_module)
        this.binding.iHeaderLayout.iBtnAddProducts.setOnClickListener {
            navController.navigateUp() // to clear previous navigation history
            navController.navigate(R.id.newProductFragment)
        }

        this.configureDrawMenu()
    }

    private fun configureDrawMenu() {
        this.binding.iNavViewLayout.tvUserName.text = "Gustavo Hernandez Parra"
        this.binding.iNavViewLayout.tvEmployeeId.text = "#00001"
        this.binding.iNavViewLayout.chpEmployeeRol.text = getString(R.string.str_warehouse_rol)
        

        this.binding.iNavViewLayout.btnClose.setOnClickListener {
            // Todo - Realizar Servicio de Logout
            this.finish()
        }
    }
}