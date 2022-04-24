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
import androidx.fragment.app.viewModels
import com.mx.farmaluxa.login.data.model.request.LoginEntityRequest
import com.mx.farmaluxa.login.databinding.FragmentLoginBinding
import com.mx.farmaluxa.login.ui.viewmodel.LoginViewModel
import com.mx.farmaluxa.warehouse.ui.view.WarehouseActivity

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

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
            val entity = LoginEntityRequest(
                username = this.binding.tilUser.editText!!.toString(),
                password = this.binding.tilPassword.editText!!.toString()
            )

            this.viewModel.getLoginViewModel(this.requireContext(), entity)
            this.viewModel.mldLoginEntity.observe(viewLifecycleOwner) {
                this.showWarehouse()
            }


//            val user = this.binding.tilUser.editText!!.text.toString()
//            val pass = this.binding.tilPassword.editText!!.text.toString()
//            if(user == "admin" && pass == "pass"){
//                this.showWarehouse()
//            } else {
//
//                this.binding.tilPassword.editText!!.setText("")
//                SUUtil.MaterialAlertDialog(this.requireContext(), "Usuario o contraseña incorrecto")
//            }

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
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
        return isInstalled
    }

    private fun showWarehouse() {
        val intent = Intent(this.requireContext(), WarehouseActivity::class.java)
        startActivity(intent)
    }
}