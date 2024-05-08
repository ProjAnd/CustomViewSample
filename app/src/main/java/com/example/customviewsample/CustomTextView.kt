package com.example.customviewsample

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomTextView (context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    init{
        applyFont(attrs)
    }

    private fun applyFont(attrs: AttributeSet?) {
        val headlineTypeFace : Typeface = Typeface.create("MonteSerrat Bold", Typeface.BOLD)
        val headlineTypeFaceItallic : Typeface = Typeface.create("MonteSerrat Bold", Typeface.ITALIC)

        //var tr : TypedArray = context.obtainStyledAttributes(attrs,R.styleable.CustomTextView)
        //var type = tr.getString(R.styleable.CustomTextView_type)
//
//        when(type){
//            "bold" ->{
//                this.typeface = headlineTypeFace
//            }
//            "italic" ->{
//                this.typeface = headlineTypeFaceItallic
//            }
//        }
//
//        tr.recycle()

    }


}