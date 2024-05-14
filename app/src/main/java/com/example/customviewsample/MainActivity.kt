package com.example.customviewsample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var customButton:CustomButton

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customButton = findViewById(R.id.customButton)

        customButton.setOnClickListener {
            //Utils.showToastFailure(this)
            //Utils.showToastSuccess(this)
            //Utils.showDialogBox(this)
            //Utils.showAlertDialogBix(this)

            var ft  = supportFragmentManager.beginTransaction()
            var prevdialog = supportFragmentManager.findFragmentByTag("dialog")

            if(prevdialog!=null){
                   ft.remove(prevdialog)
            }

               var customDialog = Dialog_FullScrenn.getInstance("Alert !",
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
    }

}