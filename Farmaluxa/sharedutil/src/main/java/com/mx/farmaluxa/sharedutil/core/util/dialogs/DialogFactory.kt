package com.mx.farmaluxa.sharedutil.core.util.dialogs

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import com.mx.farmaluxa.sharedutil.R
import com.mx.farmaluxa.sharedutil.core.util.SUConstants
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class DialogFactory {

    private val calendar: Calendar by lazy {
        Calendar.getInstance()
    }

    private val calendarSelected: Calendar by lazy {
        Calendar.getInstance()
    }

    fun getDialog(
        message: String,
        context: Context,
        type: TypeDialog,
        callbackQuestionDialog: ((Boolean) -> Unit?)? = null
    ) : AlertDialog.Builder  {
         return when(type) {
            TypeDialog.TYPE_ERROR -> {
                AlertDialog.Builder(context)
                    .setTitle(R.string.str_title_alert)
                    .setMessage(message)
            }
            TypeDialog.TYPE_SUCCESS -> {
                AlertDialog.Builder(context)
                    .setTitle(R.string.str_title_alert)
                    .setMessage(message)
            }
            TypeDialog.TYPE_QUESTION -> {
                AlertDialog.Builder(context)
                    .setTitle(R.string.str_title_alert)
                    .setMessage(message)
                    .setPositiveButton(R.string.str_accept) { d, _ ->
                        if (callbackQuestionDialog != null) {
                            callbackQuestionDialog(true)
                        }
                    }
                    .setNegativeButton(R.string.str_cancel) { d, _ ->
                        d.dismiss()
                    }
            }
        }
    }


    fun showDatePickerDialog(context: Context, callbackResult: (String) -> Unit): DatePickerDialog {
        val currentYear = this.calendar.get(Calendar.YEAR)
        val currentMonth = this.calendar.get(Calendar.MONTH)
        val currentDay = this.calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(context, { _, year, month, dayOfMonth ->
            this.calendarSelected.set(Calendar.YEAR, year)
            this.calendarSelected.set(Calendar.MONTH, month)
            this.calendarSelected.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val dateFormat = SimpleDateFormat(SUConstants.FORMAT_DATE, Locale.getDefault())
            callbackResult(dateFormat.format(this.calendarSelected.time))
        }, currentYear, currentMonth, currentDay)

        // set minimum date to be selected as today
        datePicker.datePicker.minDate = this.calendar.timeInMillis

        // return DatePicker
        return datePicker
    }

    enum class TypeDialog: Serializable {
        TYPE_ERROR,
        TYPE_SUCCESS,
        TYPE_QUESTION
    }
}