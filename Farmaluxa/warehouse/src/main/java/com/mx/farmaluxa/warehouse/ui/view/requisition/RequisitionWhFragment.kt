package com.mx.farmaluxa.warehouse.ui.view.requisition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.mx.farmaluxa.warehouse.R
import com.mx.farmaluxa.warehouse.databinding.FragmentRequisitionWhBinding
import com.mx.farmaluxa.warehouse.ui.view.viewmodel.requisition.RequisitionWhViewModel

/**
 * A simple [Fragment] subclass.
 */
class RequisitionWhFragment : Fragment() {

    private lateinit var binding: FragmentRequisitionWhBinding
    private val viewModel: RequisitionWhViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        this.binding = FragmentRequisitionWhBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.viewModel.setAdapterInRecyclerView(
            recycler = this.binding.rvRequisition
        )

        this.serviceGetAllRequisitions()

        this.binding.iBtnAdvancedFilter.setOnClickListener {
            it.findNavController().navigate(R.id.to_filterRequisitionDialogFragment)
        }

        this.viewModel.isLoading.observe(this.viewLifecycleOwner) {

        }
    }

    private fun serviceGetAllRequisitions() {
        this.viewModel.callGetAllRequisitions()
        this.viewModel.mldRequisitionsViewModel.observe(this.viewLifecycleOwner) {
            this.viewModel.setItemsInRecyclerAdapter(it)
        }
    }
}