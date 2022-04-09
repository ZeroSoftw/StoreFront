package com.mx.farmaluxa.warehouse.ui.view.product

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mx.farmaluxa.warehouse.databinding.FragmentNewProductBinding
import com.mx.farmaluxa.sharedutil.R
import com.mx.farmaluxa.warehouse.ui.view.viewmodel.product.NewProductViewModel


/**
 * A simple [Fragment] subclass.
 */
class NewProductFragment : DialogFragment() {

    private lateinit var binding: FragmentNewProductBinding
    private val viewModel: NewProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        this.binding = FragmentNewProductBinding.inflate(inflater, container, false)

        return this.binding.root
    }


    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

}