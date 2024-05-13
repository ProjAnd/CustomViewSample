package com.example.customviewsample

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginStart
import androidx.core.view.marginTop

class CustomButton(context: Context, attrs: AttributeSet?) : AppCompatButton(context, attrs) {
    init{
        makeButton()
    }

    private fun makeButton() {
        this.background = context!!.resources.getDrawable(R.drawable.button_background_released)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event!!.action){
            MotionEvent.ACTION_UP->{
                this.background = context!!.resources.getDrawable(R.drawable.button_background_released)
            }

            MotionEvent.ACTION_DOWN->{
                this.background = context!!.resources.getDrawable(R.drawable.button_background_pressed)
            }
        }
        return super.onTouchEvent(event)
    }

}