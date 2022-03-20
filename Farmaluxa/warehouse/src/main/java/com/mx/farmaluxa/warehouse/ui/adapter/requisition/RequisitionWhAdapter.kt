package com.mx.farmaluxa.warehouse.ui.adapter.requisition

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mx.farmaluxa.warehouse.data.model.entity.RequisitionEntity
import com.mx.farmaluxa.warehouse.databinding.ItemRecyclerRequisitionWhLayoutBinding
import com.mx.farmaluxa.warehouse.ui.view.holder.requisition.RequisitionWhViewHolder
import com.mx.farmaluxa.warehouse.ui.view.viewmodel.requisition.RequisitionWhViewModel

class RequisitionWhAdapter(
    private var viewModel: RequisitionWhViewModel
) : RecyclerView.Adapter<RequisitionWhViewHolder>() {

    private var lstDataItems: MutableList<RequisitionEntity>? = null

    fun setDataList(setOptionsItem: MutableList<RequisitionEntity>) {
        this.lstDataItems = setOptionsItem
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RequisitionWhViewHolder {
        val binding = ItemRecyclerRequisitionWhLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return RequisitionWhViewHolder(binding, this.viewModel, parent.context)
    }

    override fun getItemCount(): Int {
        return this.lstDataItems?.size ?: 0
    }

    override fun onBindViewHolder(holder: RequisitionWhViewHolder, position: Int) {
        this.lstDataItems?.let {
            holder.updateView(it[position])
        }
    }
}