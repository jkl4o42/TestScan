package com.jkl.testscan.scan.presentation.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.jkl.testscan.main.presentation.view.ClickAnimation

class DefaultButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr), ClickAnimation {

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener {
            animateClick { l?.onClick(it) }
        }
    }
}