package com.example.customviewsample

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View

class CustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    lateinit var type: String
    init{

        val headlineTypeFace : Typeface = Typeface.create("MonteSerrat Bold", Typeface.BOLD)
        val headlineTypeFaceItallic : Typeface = Typeface.create("MonteSerrat Bold", Typeface.ITALIC)

        var tr : TypedArray = context!!.obtainStyledAttributes(attrs,R.styleable.CustomView)
        type = tr.getString(R.styleable.CustomView_type)!!

        tr.recycle()
    }



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        when(type){
            "rect" ->{
                val paint = Paint(Paint.ANTI_ALIAS_FLAG)
                paint.setColor(Color.BLACK)
                paint.setStyle(Paint.Style.STROKE)
                paint.setStrokeWidth(2f)
                canvas!!.drawRect(10f, 10f, 10f, 10f, paint)

            }
            "circle" ->{
                val paint = Paint(Paint.ANTI_ALIAS_FLAG)
                paint.setColor(Color.BLACK)
                paint.setStyle(Paint.Style.STROKE)
                paint.setStrokeWidth(2f)
                canvas!!.drawCircle(10f, 10f, 50f, paint)


            }
            "roundrect"->{
                val paint = Paint(Paint.ANTI_ALIAS_FLAG)
                paint.setColor(Color.BLACK)
                paint.setStyle(Paint.Style.STROKE)
                paint.setStrokeWidth(2f)
                var rectF = RectF()
                canvas!!.drawRoundRect(rectF,10f, 5f, paint)

            }
        }


    }

}