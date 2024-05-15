package com.example.customviewsample

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.marginTop

class CustomEditText(context: Context, attrs: AttributeSet?) : AppCompatEditText(context, attrs) {

    init {
        makeEditText(context,attrs)
    }

    private fun makeEditText(context: Context, attrs: AttributeSet?) {
        var ta : TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText)
        var errorHint = ta.getString(R.styleable.CustomEditText_error)
        var text_type_face = Typeface.createFromAsset(context.assets, "notosans_condensed_medium.ttf")

        this.background = resources.getDrawable(R.drawable.et_background)
        this.setTextColor(resources.getColor(R.color.black))
        this.setHintTextColor(resources.getColor(R.color.gray))
        this.isCursorVisible = true
        this.textSize = 14f
        this.typeface = text_type_face
        //this.error = errorHint

    }

}