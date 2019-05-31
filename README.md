https://www.simpalm.com/
# Simpalm Dialog Helper

##Description
This Library includes multiple custom dialog which we generally use in our ongoing projects. In this library we have multiple options to make user experience more soothing.

This library can reduce the extra code and the work load from project and developer respectively.
The minimum Android version supported by this library is 4.3.

## Usage:

Step 1. Add it in your root build.gradle at the end of repositories:
``` java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
``` java
dependencies {
	        implementation 'com.github.simpalm:AndroidDialogHelper:1.0'
	}
```
Here these are the multiple option provided by this library to the developers.

1. Ok Dialog with single button: this option provide a basic dialog which contains a message and a ok button.
2. Ok Cancel Dialog: this option provide an Alert dialog with option of position and negative output buttons.
3. Date Dialog: this option provide date picker dialog
4. Time Dialog: this option provide time picker dialog
5. List Dialog: this dialog provide list dialog having user define list of options and having click output with item object and index.

## Usage
``` java
1. DialogHelper.showOk(this,"Ok Dialog","This ok dailog",object : View.OnClickListener{
    override fun onClick(p0: View?) {
	
    }
},false)

2. DialogHelper.showDialogCustomOkCancel(this,"This Custom Dialog", object : DialogHelper.OnClickListener{
    override fun onClickButtonOk() {

    }
},false)

3. DialogHelper.showDatePicker(this,"Select date", Calendar.getInstance(),object : DialogHelper.DateDialogListener{
    override fun onDateSet(calendar: Calendar) {
        val day=calendar.get(Calendar.DAY_OF_MONTH)
        val year=calendar.get(Calendar.YEAR)
        val month=calendar.get(Calendar.MONTH)+1
        Toast.makeText(this@MainActivity,"Selected Date: $day/$month/$year",Toast.LENGTH_LONG).show()
    }
},false)

4. DialogHelper.showTimerDialog(this,"Select Time", Calendar.getInstance(),object  : DialogHelper.TimeDialogListener{
    override fun onTimeSet(hour: Int, minute: Int) {
        Toast.makeText(this@MainActivity,"Selected Time: $hour:$minute",Toast.LENGTH_LONG).show()
    }
},false)

5. DialogHelper.showListDialog(this,"List Dailog",object : DialogHelper.ListDialogListener{
    override fun onItemClick(position: Int, item: String) {
        toast.maketext(this@mainactivity,"$item",toast.length_long).show()
    }

    override fun onCancel() {

    }

}, false,"Hello", "How are you", "Are you good?"  )

6. DialogHelper.showOkCancelDialog(this,"Alert","Ok Cancel message diaplay","Ok",object : View.OnClickListener{
    override fun onClick(p0: View?) {
        Toast.makeText(this@MainActivity,"Ok Pressed",Toast.LENGTH_LONG).show()
    }

},"Cancel",object : View.OnClickListener{
    override fun onClick(p0: View?) {
        Toast.makeText(this@MainActivity,"Cancel Pressed",Toast.LENGTH_LONG).show()
    }
},true)
```
Happy coding..

https://www.simpalm.com/
## License

    Copyright 2019 Simpalm. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
