package com.example.customviewsample

import android.annotation.SuppressLint
import android.content.DialogInterface.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var customButton:CustomButton
    private lateinit var btnDialog:CustomButton
    private lateinit var btnToastSuccess:CustomButton
    private lateinit var btnToastError:CustomButton

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customButton = findViewById(R.id.customButton)
        btnDialog = findViewById(R.id.btn_dialog)
        btnToastSuccess = findViewById(R.id.btn_toast_success)
        btnToastError = findViewById(R.id.btn_toast_error)

        customButton.setOnClickListener(this)
        btnDialog.setOnClickListener(this)
        btnToastSuccess.setOnClickListener(this)
        btnToastError.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.customButton->{
                var ft  = supportFragmentManager.beginTransaction()
                var prevdialog = supportFragmentManager.findFragmentByTag("dialog")

                if(prevdialog!=null){
                    ft.remove(prevdialog)
                }

                var customDialog = Dialog_FullScrenn.getInstance("Sign Up !",
                    "Here please give the description for the alert dialog", object:
                        Dialog_FullScrenn.OnButtonClick
                    {
                        override fun onOk() {
                            Toast.makeText(applicationContext, "Ok Clicked", Toast.LENGTH_SHORT).show()
                        }

                        override fun onCancel() {

                            //Toast.makeText(applicationContext, "onCancel Clicked", Toast.LENGTH_SHORT).show()
                        }

                    })
                //.show(ft, "dialog")
                ft.add(customDialog, "dialog")
                ft.addToBackStack("dialog").commit()
            }
            R.id.btn_dialog ->{
            Utils.showDialogBox(this)
            //Utils.showAlertDialogBix(this)
            }

            R.id.btn_toast_success ->{
                Utils.showToastSuccess(this)
            }
            R.id.btn_toast_error ->{
                Utils.showToastFailure(this)
            }


        }
    }

}