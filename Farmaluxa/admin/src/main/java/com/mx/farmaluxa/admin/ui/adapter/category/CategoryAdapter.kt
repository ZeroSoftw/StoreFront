package com.mx.farmaluxa.admin.ui.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mx.farmaluxa.admin.data.model.entity.CategoryEntity
import com.mx.farmaluxa.admin.databinding.ItemRecyclerCategoryLayoutBinding
import com.mx.farmaluxa.admin.ui.view.holder.category.CategoryViewHolder
import com.mx.farmaluxa.admin.ui.viewmodel.category.CategoryViewModel

class CategoryAdapter(
    private var viewModel: CategoryViewModel
) : RecyclerView.Adapter<CategoryViewHolder>() {

    private var lstDataItems: MutableList<CategoryEntity>? = null

    fun setDataList(setOptionsItem: MutableList<CategoryEntity>) {
        this.lstDataItems = setOptionsItem
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding = ItemRecyclerCategoryLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CategoryViewHolder(binding, this.viewModel, parent.context)
    }

    override fun getItemCount(): Int {
        return this.lstDataItems?.size ?: 0
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        this.lstDataItems?.let {
            holder.updateView(it[position])
        }
    }
}