package com.mx.farmaluxa.warehouse.ui.view.dialog.requisition

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mx.farmaluxa.sharedutil.core.util.dialogs.DialogFactory
import com.mx.farmaluxa.warehouse.R
import com.mx.farmaluxa.warehouse.databinding.DialogFragmentFilterRequisitionBinding
import com.mx.farmaluxa.warehouse.ui.view.viewmodel.dialog.requisition.FilterRequisitionViewModel

/**
 * A simple [Fragment] subclass.
 */
class FilterRequisitionDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: DialogFragmentFilterRequisitionBinding
    private val viewModel: FilterRequisitionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        this.binding = DialogFragmentFilterRequisitionBinding.inflate(inflater, container, false)

        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.viewModel.isLoading.observe(this.viewLifecycleOwner) {

        }

        this.binding.etDateFilter.setOnClickListener {
            val dialogFactory = DialogFactory()
            dialogFactory.showDatePickerDialog(
                context = this.requireContext(),
                callbackResult =  {
                    this.binding.etDateFilter.setText(it)
                }
            ).show()
        }

        this.binding.btnClearFilter.setOnClickListener {
            val dialogFactory = DialogFactory()
            dialogFactory.getDialog(
                message = getString(R.string.msg_clear_filter),
                context = this.requireContext(),
                type = DialogFactory.TypeDialog.TYPE_QUESTION,
                callbackQuestionDialog = {
                    if (it) {
                        this.clearFilter()
                    }
                }
            ).show()
        }

        this.binding.btnSaveFilter.setOnClickListener {
            this.dismiss()
        }
    }

    private fun clearFilter() {
        with(this.binding) {
            this.etDateFilter.setText("")

            this.chpStatusSupply.isChecked = false
            this.chpStatusRoute.isChecked = false
            this.chpStatusDelivered.isChecked = false
            this.chpStatusPartialCancel.isChecked = false
            this.chpStatusTotalCancel.isChecked = false
            this.chpStatusInReview.isChecked = false
        }
    }
}