package com.jkl.testscan.scan.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.airbnb.lottie.LottieDrawable
import com.jkl.testscan.R
import com.jkl.testscan.databinding.ViewScanButtonBinding
import com.jkl.testscan.main.presentation.view.ClickAnimation

class ScanButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), ClickAnimation {

    private var binding: ViewScanButtonBinding =
        ViewScanButtonBinding.inflate(LayoutInflater.from(context), this)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setupAnimation()
    }

    private fun setupAnimation() {
        binding.lottieAnimationView.repeatCount = LottieDrawable.INFINITE
        binding.lottieAnimationView.playAnimation()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener {
            animateClick { l?.onClick(it) }
        }
    }

    fun setAlerts(value: Int) {
        binding.alertAppCompatTextView.text = if (value == 0) context.getString(R.string.no_problems) else "$value ${context.getString(R.string.problems)}"
        binding.alertAppCompatTextView.setTextColor(context.getColor(if (value == 0) R.color.success else R.color.error))
        binding.iconProblemAppCompatImageView.visibility = if (value == 0) View.GONE else View.VISIBLE
    }
}