package com.example.customviewsample

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class Dialog_FullScrenn : DialogFragment() {
    lateinit var btnOk: Button
    lateinit var btnCancel: ImageView
    lateinit var tvtitle: TextView
    lateinit var tvdesc: TextView
    lateinit var title: String
    lateinit var desc: String
    lateinit var onclick: OnButtonClick


    interface OnButtonClick {
        fun onOk()
        fun onCancel()
    }

    companion object {
        private var customDialogFUllScreen: Dialog_FullScrenn? = null


        fun getInstance(title: String, desc: String, onClick: OnButtonClick): Dialog_FullScrenn {
            customDialogFUllScreen = Dialog_FullScrenn()
            var bundle = Bundle()
            bundle.putString("title", title)
            bundle.putString("desc", desc)
            customDialogFUllScreen!!.arguments = bundle
            customDialogFUllScreen!!.onclick = onClick

            return customDialogFUllScreen!!
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.dialog_full_screen)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.dialog_pouup, container, false)
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