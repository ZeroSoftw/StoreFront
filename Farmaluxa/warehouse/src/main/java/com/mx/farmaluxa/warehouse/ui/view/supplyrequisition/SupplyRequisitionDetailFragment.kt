package com.mx.farmaluxa.warehouse.ui.view.supplyrequisition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mx.farmaluxa.warehouse.data.model.request.SupplyRequistionEntityRequest
import com.mx.farmaluxa.warehouse.databinding.FragmentSupplyRequisitionDetailBinding
import com.mx.farmaluxa.warehouse.ui.adapter.supplyrequisition.SupplyRequisitionAdapter

class SupplyRequisitionDetailFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSupplyRequisitionDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.binding = FragmentSupplyRequisitionDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.updateRecyclerView()

    }

    private fun updateRecyclerView() {
        this.binding.rvProducts.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
//            adapter = SupplyRequisitionAdapter(getListProduct())
        }
    }

//    private fun getListProduct(): List<SupplyRequistionEntityRequest> {
//        listProduct = listOf(
//            SupplyRequistionEntityRequest(5, "AC Fast"),
//            SupplyRequistionEntityRequest(30, "Trezetre 30 tabletas"),
//            SupplyRequistionEntityRequest(8, ":Lexigrim 200 ml"),
//            SupplyRequistionEntityRequest(1, "Acxion 30 tabletas")
//        )
//        return listProduct!!
//    }


}