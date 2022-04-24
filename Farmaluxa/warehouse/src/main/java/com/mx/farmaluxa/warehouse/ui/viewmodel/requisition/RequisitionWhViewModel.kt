package com.mx.farmaluxa.warehouse.ui.viewmodel.requisition

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.mx.farmaluxa.warehouse.data.model.entity.RequisitionEntity
import com.mx.farmaluxa.warehouse.ui.adapter.requisition.RequisitionWhAdapter

class RequisitionWhViewModel : ViewModel() {

    var adapterRequisition: RequisitionWhAdapter? = null
    var mldRequisitionsViewModel = MutableLiveData<MutableList<RequisitionEntity>>()
    var isLoading = MutableLiveData<Boolean>()

    fun callGetAllRequisitions() {
        val mLstData: MutableList<RequisitionEntity> = arrayListOf()

        (1..10).forEach {
            mLstData.add(
                RequisitionEntity(
                    requisitionId = "21341$it",
                    nameClient = "Gustavo Hernandez Parra",
                    requestDate = "20/02/2022",
                    intStatus = 1,
                    totalProducts = it
                )
            )
        }

        this.mldRequisitionsViewModel.value = mLstData
    }

    fun setAdapterInRecyclerView(recycler: RecyclerView) {
        recycler.apply {
            val adapter = RequisitionWhAdapter(
                viewModel = this@RequisitionWhViewModel
            )

            this.adapter = adapter
            this@RequisitionWhViewModel.adapterRequisition = adapter
        }
    }

    fun setItemsInRecyclerAdapter(lstData: MutableList<RequisitionEntity>) {
        this.adapterRequisition?.setDataList(lstData)
        this.adapterRequisition?.notifyItemRangeInserted(0, lstData.size)
    }

}