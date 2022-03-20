package com.mx.farmaluxa.login.ui.view.login

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mx.farmaluxa.login.databinding.FragmentLoginBinding
import com.mx.farmaluxa.warehouse.ui.view.WarehouseActivity

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    companion object {

        fun newInstance(): LoginFragment {
            val fragment = LoginFragment()

            val args = Bundle()

            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        this.binding = FragmentLoginBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.btnLogin.setOnClickListener {
            this.showWarehouse()
        }

        this.binding.tvSignUp.setOnClickListener {
            this.openWhatsApp()
        }
    }

    private fun openWhatsApp() {
        val installed: Boolean = isWhatsAppInstalled()


        if (installed) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data =
                Uri.parse("http://api.whatsapp.com/send?phone=$+527737367499&text=Hola, me gustaría registrarme para conocer más sobre tu catálogo de productos")
            startActivity(intent)
        } else {
            Toast.makeText(
                this.requireContext(),
                com.mx.farmaluxa.sharedutil.R.string.whatsapp_is_not_installed,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun isWhatsAppInstalled(): Boolean {

        val pm: PackageManager = this.requireContext().packageManager

        val isInstalled: Boolean = try {
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
            return true;
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
        return isInstalled

    }

    private fun showWarehouse() {
        val intent = Intent(
            this.requireContext(),
            WarehouseActivity::class.java
        )

        startActivity(intent)
    }
}