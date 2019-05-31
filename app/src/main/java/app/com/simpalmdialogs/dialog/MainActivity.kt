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

package app.com.simpalmdialogs.dialog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import app.com.dialog.DialogHelper
import app.com.simpalmdialogs.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dialogBtn.setOnClickListener {
            DialogHelper.showOk(this, "Ok Dialog", "This is a ok dailog", object : View.OnClickListener {
                override fun onClick(p0: View?) {

                }
            }, false)
        }
        customDialogBtn.setOnClickListener {
            DialogHelper.showDialogCustomOkCancel(this, "This Custom Dialog", object : DialogHelper.OnClickListener {
                override fun onClickButtonOk() {

                }
            }, false)
        }

        dateDailogBtn.setOnClickListener {
            DialogHelper.showDatePicker(
                this,
                "Select date",
                Calendar.getInstance(),
                object : DialogHelper.DateDialogListener {
                    override fun onDateSet(calendar: Calendar) {
                        val day = calendar.get(Calendar.DAY_OF_MONTH)
                        val year = calendar.get(Calendar.YEAR)
                        val month = calendar.get(Calendar.MONTH) + 1
                        Toast.makeText(this@MainActivity, "Selected Date: $day/$month/$year", Toast.LENGTH_LONG).show()
                    }
                },
                false
            )
        }

        timeDailogBtn.setOnClickListener {
            DialogHelper.showTimerDialog(
                this,
                "Select Time",
                Calendar.getInstance(),
                object : DialogHelper.TimeDialogListener {
                    override fun onTimeSet(hour: Int, minute: Int) {
                        Toast.makeText(this@MainActivity, "Selected Time: $hour:$minute", Toast.LENGTH_LONG).show()
                    }
                },
                false
            )
        }

        listDialogBtn.setOnClickListener {
            DialogHelper.showListDialog(this, "List Dialog", object : DialogHelper.ListDialogListener {
                override fun onItemClick(position: Int, item: String) {
                    Toast.makeText(this@MainActivity, "$item", Toast.LENGTH_LONG).show()
                }

                override fun onCancel() {

                }

            }, false, "Item one", "Item two", "Item three", "Item four", "Item five")
        }

        okCancelBtn.setOnClickListener {
            DialogHelper.showOkCancelDialog(
                this,
                "Alert",
                "This is a dialog with Ok-cancel button",
                "Ok",
                object : View.OnClickListener {
                    override fun onClick(p0: View?) {
                        Toast.makeText(this@MainActivity, "Ok Pressed", Toast.LENGTH_LONG).show()
                    }

                },
                "Cancel",
                object : View.OnClickListener {
                    override fun onClick(p0: View?) {
                        Toast.makeText(this@MainActivity, "Cancel Pressed", Toast.LENGTH_LONG).show()
                    }
                },
                true
            )
        }


    }
}
