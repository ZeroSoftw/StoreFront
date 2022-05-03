package com.mx.farmaluxa.admin.ui.view.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.mx.farmaluxa.admin.databinding.FragmentCategoryBinding
import com.mx.farmaluxa.admin.ui.viewmodel.category.CategoryViewModel

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private val viewModel: CategoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        this.binding = FragmentCategoryBinding.inflate(inflater, container, false)

        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.viewModel.setAdapterInRecyclerView(
            recycler = this.binding.rvCategory,
            scrollListener = object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    // if the recycler view is scrolled
                    // above hide the FAB
                    if (dy > 10 && this@CategoryFragment.binding.fabAddCategory.isShown) {
                        this@CategoryFragment.binding.fabAddCategory.hide()
                    }

                    // if the recycler view is
                    // scrolled above show the FAB
                    if (dy < -10 && !this@CategoryFragment.binding.fabAddCategory.isShown) {
                        this@CategoryFragment.binding.fabAddCategory.show()
                    }

                    // of the recycler view is at the first
                    // item always show the FAB
                    if (!recyclerView.canScrollVertically(-1)) {
                        this@CategoryFragment.binding.fabAddCategory.show()
                    }
                }
            }
        )

        this.serviceGetAllCategories()

        this.binding.fabAddCategory.setOnClickListener {
            this.binding.fabAddCategory.isExtended = !this.binding.fabAddCategory.isExtended
        }

        this.viewModel.isLoading.observe(this.viewLifecycleOwner) {

        }
    }

    private fun serviceGetAllCategories() {
        this.viewModel.callGetAllCategories()
        this.viewModel.mldCategoriesViewModel.observe(this.viewLifecycleOwner) {
            this.viewModel.setItemsInRecyclerAdapter(it)
        }
    }
}