package com.jkl.testscan.scan.presentation

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.jkl.testscan.databinding.FragmentScanBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class ScanFragment : Fragment() {

    private lateinit var binding: FragmentScanBinding
    private val viewModel: ScanViewModel by lazy { ViewModelProvider(this)[ScanViewModel::class] }
    private val dashboardAdapter = DashboardAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomSheet()
        binding.scanButton.setOnClickListener { viewModel.startScan() }
        binding.dashboardRecyclerView.adapter = dashboardAdapter
        viewModel.observeDashboard(viewLifecycleOwner) { list ->
            dashboardAdapter.update(list)
            val allDetails = list.map { it.details }
            binding.scanButton.setAlerts(allDetails.sumOf { it.alerts })
        }
    }

    private fun setupBottomSheet() {
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.dashboardFrameLayout)

        val displayMetrics = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        val screenHeight = displayMetrics.heightPixels
        val maxHeight = screenHeight - (150 * resources.displayMetrics.density).toInt()

        binding.dashboardFrameLayout.layoutParams.height = maxHeight
        binding.dashboardFrameLayout.requestLayout()

        binding.containerLinearLayoutCompat.viewTreeObserver.addOnGlobalLayoutListener {
            bottomSheetBehavior.peekHeight = screenHeight - (binding.containerLinearLayoutCompat.height + 150)
        }
    }
}