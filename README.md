# SimplamDailogs


Start:
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
   
   dependencies {
	        implementation 'com.github.pamujsharma1:SimplamDailogs:1.0.1'
	}




/*
    * there is OKDialog,DateDialog,TimeDialog,ListDialog & OkCancelDialog
    * Please call There dialog classes and you will find all methords
    * */
    
    example:-
     dialogBtn.setOnClickListener {
            OKDialog.showOk(this,"Ok Dialog","This ok dailog",object : View.OnClickListener{
                override fun onClick(p0: View?) {

                }
            })
        }
        customDialogBtn.setOnClickListener {
            CustomDialog.showDialogCustomOkCancel(this,"This Custom Dialog", object : CustomDialog.OnClickListener{
                override fun onClickButtonOk() {

                }
            })
        }

        dateDailogBtn.setOnClickListener {
            DateDialog.show(this,"Select date", Calendar.getInstance(),object : DateDialog.DateDialogListener{
                override fun onDateSet(calendar: Calendar) {
                    val day=calendar.get(Calendar.DAY_OF_MONTH)
                    val year=calendar.get(Calendar.YEAR)
                    val month=calendar.get(Calendar.MONTH)+1
                    Toast.makeText(this@MainActivity,"Selected Date: $day/$month/$year",Toast.LENGTH_LONG).show()
                }
            })
        }

        timeDailogBtn.setOnClickListener {
            TimeDialog.show(this,"Select Time", Calendar.getInstance(),object  : TimeDialog.TimeDialogListener{
                override fun onTimeSet(hour: Int, minute: Int) {
                    Toast.makeText(this@MainActivity,"Selected Time: $hour:$minute",Toast.LENGTH_LONG).show()
                }
            })
        }

        listDialogBtn.setOnClickListener {
            ListDialog.show(this,"List Dailog",object : ListDialog.ListDialogListener{
                override fun onItemClick(position: Int, item: String) {
                    Toast.makeText(this@MainActivity,"Selected :$position Item: $item",Toast.LENGTH_LONG).show()
                }

                override fun onCancel() {

                }

            }, "hello", "How are you", "Are you good?")
        }

        okCancelBtn.setOnClickListener {
            OkCancelDialog.show(this,"Alert","Ok Cancel message diaplay","Ok",object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    Toast.makeText(this@MainActivity,"Ok Pressed",Toast.LENGTH_LONG).show()
                }

            },"Cancel",object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    Toast.makeText(this@MainActivity,"Cancel Pressed",Toast.LENGTH_LONG).show()
                }
            })
        }
    
