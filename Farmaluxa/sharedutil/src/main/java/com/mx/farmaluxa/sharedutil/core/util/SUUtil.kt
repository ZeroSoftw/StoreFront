package com.mx.farmaluxa.sharedutil.core.util

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mx.farmaluxa.sharedutil.R

class SUUtil {

    companion object{

        fun MaterialAlertDialog(context: Context, message: String){
            MaterialAlertDialogBuilder(context)
                .setTitle(R.string.str_title_alert)
                .setCancelable(false)
                .setMessage(message)
                .setNegativeButton(R.string.str_cancel){dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

    }
}