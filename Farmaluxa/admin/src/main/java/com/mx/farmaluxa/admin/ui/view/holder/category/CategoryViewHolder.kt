package com.mx.farmaluxa.admin.ui.view.holder.category

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.mx.farmaluxa.admin.R
import com.mx.farmaluxa.admin.data.model.entity.CategoryEntity
import com.mx.farmaluxa.admin.databinding.ItemRecyclerCategoryLayoutBinding
import com.mx.farmaluxa.admin.ui.viewmodel.category.CategoryViewModel

class CategoryViewHolder(
    private val binding: ItemRecyclerCategoryLayoutBinding,
    private val viewModel: CategoryViewModel,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun updateView(entity: CategoryEntity) {
        this.binding.tvCategory.text = context.getString(
            R.string.str_category_holder,
            entity.categoryKey,
            entity.categoryName
        )

        this.binding.root.setOnClickListener {
            this.viewModel.onCategorySelected(entity)
        }
    }

}