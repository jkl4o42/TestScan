package com.jkl.testscan.main.presentation.view

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View
import androidx.core.animation.doOnEnd

interface ClickAnimation {
    fun animateClick(cb: () -> Unit) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.0f, 0.8f, 1.0f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.0f, 0.8f, 1.0f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(this, scaleX, scaleY)
        animator.duration = 200
        animator.start()
        animator.doOnEnd {
            cb.invoke()
        }
    }
}