package com.mx.farmaluxa.warehouse.ui.adapter.supplyrequisition

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mx.farmaluxa.warehouse.data.model.request.SupplyRequistionEntityRequest
import com.mx.farmaluxa.warehouse.databinding.ItemRecyclerSupplyRequisitionLayoutBinding

class SupplyRequisitionAdapter(
    private val list: List<SupplyRequistionEntityRequest>
) : RecyclerView.Adapter<SupplyRequisitionAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context

        val binding = ItemRecyclerSupplyRequisitionLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = list[position]

        with(holder) {
            binding.tvQuantity.text = "0"
            binding.tvProduct.text = entity.nombre
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(val binding: ItemRecyclerSupplyRequisitionLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}