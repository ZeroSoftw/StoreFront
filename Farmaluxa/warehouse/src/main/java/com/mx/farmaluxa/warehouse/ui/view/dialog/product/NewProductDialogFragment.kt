package com.mx.farmaluxa.warehouse.ui.view.dialog.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mx.farmaluxa.sharedutil.R
import com.mx.farmaluxa.warehouse.databinding.DialogFragmentNewProductBinding
import com.mx.farmaluxa.warehouse.ui.viewmodel.dialog.product.NewProductViewModel

class NewProductDialogFragment : DialogFragment() {

    private lateinit var binding: DialogFragmentNewProductBinding
    private val viewModel: NewProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        this.binding = DialogFragmentNewProductBinding.inflate(inflater, container, false)

        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.configureToolbar()

        this.binding.btnAddProduct.setOnClickListener {
            this.serviceSaveNewProduct()
        }

        this.viewModel.isLoading.observe(this.viewLifecycleOwner) {

        }
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    private fun configureToolbar() {
        this.binding.iToolbar.iBtnCloseDialog.setOnClickListener {
            this.dismiss()
        }
    }

    private fun serviceSaveNewProduct() {
        this.dismiss()
    }
}