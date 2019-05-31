/*
 * Copyright 2019 Simpalm. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.com.dialog

import android.app.*
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import app.com.simplamdialogs.R
import java.util.*

object DialogHelper {
    fun showDialogCustomOk(context: Context, message: String, onClickListener: OnClickListener, isCancelable: Boolean) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.custompopup)
        dialog.setCancelable(isCancelable)
        val textTitle = dialog.findViewById<TextView>(R.id.textTitle)
        textTitle.text = message
        val close = dialog.findViewById<ImageView>(R.id.close)
        close.setOnClickListener {
            dialog.dismiss()
        }
        val cancelBtn = dialog.findViewById<Button>(R.id.cancelBtn)
        cancelBtn.visibility = View.GONE
        val ok = dialog.findViewById<Button>(R.id.ok)
        ok.setOnClickListener {
            onClickListener.onClickButtonOk()
            dialog.dismiss()
        }
        dialog.getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

    }

    fun showDialogCustomOkCancel(
        context: Context,
        message: String,
        onClickListener: OnClickListener,
        isCancelable: Boolean
    ) {
        var dialog = Dialog(context)
        dialog.setContentView(R.layout.custompopup)
        dialog.setCancelable(isCancelable)

        val textTitle = dialog.findViewById<TextView>(R.id.textTitle)
        textTitle.text = message

        val close = dialog.findViewById<ImageView>(R.id.close)
        close.setOnClickListener {
            dialog.dismiss()
        }
        val cancelBtn = dialog.findViewById<Button>(R.id.cancelBtn)
        cancelBtn.setOnClickListener {
            dialog.dismiss()
        }
        val ok = dialog.findViewById<Button>(R.id.ok)
        ok.setOnClickListener {
            onClickListener.onClickButtonOk()
            dialog.dismiss()
        }
        dialog.getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

    }

    fun showDatePicker(
        activity: Activity,
        title: String,
        calendar: Calendar?,
        listener: DateDialogListener?,
        isCancelable: Boolean
    ) {
        var calendar = calendar
        if (null == calendar) {
            calendar = Calendar.getInstance()
        }

        val dialog = DatePickerDialog(
            activity,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
                if (null != listener) {
                    val cal = Calendar.getInstance()
                    cal.set(selectedYear, selectedMonth, selectedDay)
                    listener.onDateSet(cal)
                }
            },
            calendar!!.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        dialog.setCancelable(isCancelable)
        dialog.show()
    }

    fun showListDialog(
        context: Context,
        title: String?,
        listener: ListDialogListener?,
        isCancelable: Boolean,
        vararg options: String
    ) {
        val builder = AlertDialog.Builder(context)
        if (null != title && title.trim { it <= ' ' }.length > 0) {
            builder.setTitle(title)
        }
        builder.setItems(options) { dialog, item ->
            listener?.onItemClick(item, options[item])
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
            listener?.onCancel()
        }

        val alertDialog = builder.create()
        alertDialog.setCancelable(isCancelable)
        alertDialog.show()
    }

    fun showOkCancelDialog(
        context: Context, titleResId: String, message: String, okBtntext: String, okListener: View.OnClickListener?,
        cancelBtnText: String, cancelListener: View.OnClickListener?, isCancelable: Boolean
    ) {
        val adb = AlertDialog.Builder(context)
        adb.setTitle(titleResId)
        adb.setMessage(message)
        adb.setCancelable(isCancelable)
        adb.setPositiveButton(okBtntext) { dialog, which ->
            okListener?.onClick(null)
        }


        adb.setNegativeButton(cancelBtnText) { dialog, which ->
            cancelListener?.onClick(null)
        }
        adb.show()
    }

    fun showOkWithoutListener(mcContext: Context, no_network: Int, s: String, isCancelable: Boolean) {
        AlertDialog.Builder(mcContext)
            .setTitle(mcContext.resources.getString(no_network))
            .setMessage(s)
            .setPositiveButton("OK") { dialog, which ->
                dialog.dismiss()
            }
            .setCancelable(isCancelable)
            .show()
    }

    fun showOk(
        mcContext: Context,
        title: String,
        message: String,
        onClickListener: View.OnClickListener,
        isCancelable: Boolean
    ) {
        AlertDialog.Builder(mcContext)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, which ->
                dialog.dismiss()
                onClickListener.onClick(null)
            }
            .setCancelable(isCancelable)
            .show()
    }

    fun showTimerDialog(
        activity: Activity,
        title: String,
        calendar: Calendar?,
        listener: TimeDialogListener?,
        isCancelable: Boolean
    ) {
        var calendar = calendar
        if (null == calendar) {
            calendar = Calendar.getInstance()
        }

        val dialog = TimePickerDialog(activity, TimePickerDialog.OnTimeSetListener { timePicker, hour, minutes ->
            listener?.onTimeSet(hour, minutes)
        }, calendar!!.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false)
        dialog.setTitle(title)
        dialog.setCancelable(isCancelable)
        dialog.show()
    }

    interface TimeDialogListener {
        fun onTimeSet(hour: Int, minute: Int)
    }

    interface ListDialogListener {
        fun onItemClick(position: Int, item: String)

        fun onCancel()
    }

    interface DateDialogListener {
        fun onDateSet(calendar: Calendar)
    }

    interface OnClickListener {
        fun onClickButtonOk()
    }
}