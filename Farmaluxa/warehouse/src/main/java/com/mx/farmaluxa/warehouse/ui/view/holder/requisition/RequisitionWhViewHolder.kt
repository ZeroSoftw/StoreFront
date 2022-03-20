package com.mx.farmaluxa.warehouse.ui.view.holder.requisition

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.mx.farmaluxa.warehouse.R
import com.mx.farmaluxa.warehouse.data.model.entity.RequisitionEntity
import com.mx.farmaluxa.warehouse.databinding.ItemRecyclerRequisitionWhLayoutBinding
import com.mx.farmaluxa.warehouse.ui.view.viewmodel.requisition.RequisitionWhViewModel

class RequisitionWhViewHolder(
    private val binding: ItemRecyclerRequisitionWhLayoutBinding,
    private val viewModel: RequisitionWhViewModel,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun updateView(entity: RequisitionEntity) {
        this.binding.tvRequisitionNum.text = this.context.getString(
            R.string.str_num_requisition,
            entity.requisitionId
        )
        this.binding.tvClientName.text = entity.nameClient
        this.binding.tvDateRequest.text = entity.requestDate
        var totalProducts = this.context.getString(
            R.string.str_num_product,
            entity.totalProducts
        )

        if (entity.totalProducts > 1) {
            totalProducts += "s"
        }

        this.binding.tvProducts.text = totalProducts

        this.binding.chpStatus.text = this.getStatus(entity.intStatus)
    }

    private fun getStatus(status: Int): String {
        return "Surtimiento"
    }

}