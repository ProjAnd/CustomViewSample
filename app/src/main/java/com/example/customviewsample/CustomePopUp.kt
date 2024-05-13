package com.example.customviewsample

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import java.util.Vector


class CustomePopUp : DialogFragment() {
    lateinit var btnOk: Button
    lateinit var btnCancel:Button
    lateinit var tvtitle:TextView
    lateinit var tvdesc:TextView
    lateinit var title :String
    lateinit var desc :String
    lateinit var onclick :OnButtonClick


    interface OnButtonClick{
        fun onOk()
        fun onCancel()
    }

    companion object {
        private var customPopupInsance: CustomePopUp?=null


        fun getInstance(title:String, desc:String, onClick:OnButtonClick):CustomePopUp{
                 customPopupInsance = CustomePopUp()
                 var bundle = Bundle()
                 bundle.putString("title", title)
                 bundle.putString("desc", desc)
                 customPopupInsance!!.arguments = bundle
                 customPopupInsance!!.onclick = onClick

                 return customPopupInsance!!
        }


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.customDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.pupup, container,false)
        tvtitle = view.findViewById(R.id.tv_title)
        tvdesc = view.findViewById(R.id.tv_desc)
        btnOk = view.findViewById(R.id.btn_ok)
        btnCancel = view.findViewById(R.id.btn_cancel)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var bundle = arguments
        tvtitle.text = bundle!!.getString("title")
        tvdesc.text = bundle!!.getString("desc")
        btnOk.setOnClickListener {
          onclick.onOk()
        }

        btnCancel.setOnClickListener {
            this.dismiss()
            //onclick.onCancel()
        }

    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        dialog.dismiss()
    }

}