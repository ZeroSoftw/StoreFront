package com.mx.farmaluxa.warehouse.ui.view.supplyrequisition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mx.farmaluxa.warehouse.data.model.request.SupplyRequistionEntityRequest
import com.mx.farmaluxa.warehouse.databinding.FragmentSupplyRequisitionBinding
import com.mx.farmaluxa.warehouse.ui.adapter.supplyrequisition.SupplyRequisitionAdapter

class SupplyRequisitionFragment : Fragment() {

    private lateinit var binding: FragmentSupplyRequisitionBinding

    private var listProduct: List<SupplyRequistionEntityRequest>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.binding = FragmentSupplyRequisitionBinding.inflate(inflater, container, false)

        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.updateRecyclerView()
    }

    private fun getListProduct(): List<SupplyRequistionEntityRequest> {
        listProduct = listOf(
            SupplyRequistionEntityRequest(5, "AC Fast"),
            SupplyRequistionEntityRequest(30, "Trezetre 30 tabletas"),
            SupplyRequistionEntityRequest(8, ":Lexigrim 200 ml"),
            SupplyRequistionEntityRequest(1, "Acxion 30 tabletas")
        )
        return listProduct!!
    }

    private fun updateRecyclerView() {
        this.binding.rvProducts.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = SupplyRequisitionAdapter(getListProduct())
        }
    }
}