package com.mx.farmaluxa.admin.ui.viewmodel.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.mx.farmaluxa.admin.data.model.entity.CategoryEntity
import com.mx.farmaluxa.admin.ui.adapter.category.CategoryAdapter
import com.mx.farmaluxa.sharedutil.core.util.ui.Event

class CategoryViewModel : ViewModel() {

    var adapterRequisition: CategoryAdapter? = null
    var mldCategoriesViewModel = MutableLiveData<MutableList<CategoryEntity>>()
    var isLoading = MutableLiveData<Boolean>()
    var categorySelected =  MutableLiveData<Event<CategoryEntity>>()

    fun callGetAllCategories() {
        val mLstData: MutableList<CategoryEntity> = arrayListOf()

        (1..30).forEach {
            mLstData.add(
                CategoryEntity(
                    categoryKey = "EX",
                    categoryName = "Example $it"
                )
            )
        }

        this.mldCategoriesViewModel.value = mLstData
    }

    fun setAdapterInRecyclerView(recycler: RecyclerView, scrollListener: RecyclerView.OnScrollListener) {
        recycler.apply {
            val adapter = CategoryAdapter(
                viewModel = this@CategoryViewModel
            )

            this.adapter = adapter
            this@CategoryViewModel.adapterRequisition = adapter

            this.addOnScrollListener(scrollListener)
        }
    }

    fun setItemsInRecyclerAdapter(lstData: MutableList<CategoryEntity>) {
        this.adapterRequisition?.setDataList(lstData)
        this.adapterRequisition?.notifyItemRangeInserted(0, lstData.size)
    }

    fun onCategorySelected(entity: CategoryEntity) {
        this.categorySelected.value = Event(entity)
    }

}