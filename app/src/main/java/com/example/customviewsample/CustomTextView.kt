package com.example.customviewsample

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomTextView (context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    init{
        applyFont(attrs)
    }

    private fun applyFont(attrs: AttributeSet?) {
        val headlineTypeFaceBold : Typeface = Typeface.create("MonteSerrat Bold", Typeface.BOLD)
        val headlineTypeFaceItallic : Typeface = Typeface.create("MonteSerrat Bold", Typeface.ITALIC)
        val fonttf_bold = Typeface.createFromAsset(context.assets, "notonanscondensed_bold.ttf")
        val fonttf_medium = Typeface.createFromAsset(context.assets, "notosans_condensed_medium.ttf")
        val fonttf_regular = Typeface.createFromAsset(context.assets, "notosans_condensed_regular.ttf")

        var tr : TypedArray = context.obtainStyledAttributes(attrs,R.styleable.CustomTextView)
        var type = tr.getString(R.styleable.CustomTextView_type)

        when(type){
            "headline" ->{
                this.typeface = fonttf_bold
                this.textSize = 20f
                this.text = "Headline"
            }
            "description" ->{
                this.typeface = fonttf_medium
                this.textSize = 15f
                this.text = "Description"
            }
            "normal" ->{
                this.typeface = fonttf_regular
                this.textSize = 14f
                this.text = "Normal Text"
            }
        }

        tr.recycle()

    }

   constructor(context: Context, attrs: AttributeSet?, name:String) : this(context, attrs) {

   }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}