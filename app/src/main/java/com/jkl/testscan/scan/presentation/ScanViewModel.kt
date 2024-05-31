package com.jkl.testscan.scan.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkl.testscan.R
import com.jkl.testscan.scan.data.DashboardDetails
import com.jkl.testscan.scan.data.DashboardEntity
import com.jkl.testscan.scan.data.DashboardItemType
import com.jkl.testscan.scan.domain.ScanInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ScanViewModel @Inject constructor(
    private val scanInteractor: ScanInteractor
) : ViewModel() {

    private val dashboardLiveData: MutableLiveData<List<DashboardEntity>> = MutableLiveData()

    fun observeDashboard(owner: LifecycleOwner, observer: Observer<List<DashboardEntity>>) =
        dashboardLiveData.observe(owner, observer)

    fun startScan() = viewModelScope.launch(Dispatchers.IO) {
        scanInteractor.insertAll(generateDefaultList())
        dashboardLiveData.postValue(scanInteractor.dashboard())
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val list = scanInteractor.dashboard()
            dashboardLiveData.postValue(list)
            if (list.isNotEmpty()) return@launch
            val defaultItems = generateDefaultList()
            scanInteractor.insertAll(defaultItems)
            dashboardLiveData.postValue(scanInteractor.dashboard())
        }
    }

    private fun generateDefaultList(): List<DashboardEntity> = listOf(
        DashboardEntity(
            type = DashboardItemType.DeviceInfo::class.java.simpleName,
            details = DashboardDetails(
                title = "Device info",
                info = "Show you all info about phone",
                alerts = Random.nextInt(0, 5),
                icon = R.mipmap.ic_device_scan
            )
        ),
        DashboardEntity(
            type = DashboardItemType.CalibrationOfSensors::class.java.simpleName,
            details = DashboardDetails(
                title = "Calibration of sensors",
                info = "Show you all info about",
                alerts = Random.nextInt(0, 5),
                icon = R.mipmap.ic_calibration
            )
        ),
        DashboardEntity(
            type = DashboardItemType.AppMonitoring::class.java.simpleName,
            details = DashboardDetails(
                title = "App monitoring",
                info = "Show you all info about",
                alerts = Random.nextInt(0, 5),
                icon = R.mipmap.ic_app_monitoring
            )
        ),
        DashboardEntity(
            type = DashboardItemType.AntiVirus::class.java.simpleName,
            details = DashboardDetails(
                title = "AntiVirus",
                info = "Show you all info about",
                alerts = Random.nextInt(0, 5),
                icon = R.mipmap.ic_virus
            )
        ),
        DashboardEntity(
            type = DashboardItemType.DeviceMemoryInformation::class.java.simpleName,
            details = DashboardDetails(
                title = "Device Memory Information",
                info = "Show you all info about",
                alerts = Random.nextInt(0, 5),
                icon = R.mipmap.ic_memory
            )
        ),
        DashboardEntity(
            type = DashboardItemType.FileManager::class.java.simpleName,
            details = DashboardDetails(
                title = "File manager",
                info = "Show you all info about",
                alerts = Random.nextInt(0, 5),
                icon = R.mipmap.ic_file_manager
            )
        ),
        DashboardEntity(
            type = DashboardItemType.BatteryInfo::class.java.simpleName,
            details = DashboardDetails(
                title = "Battery info",
                info = "Show you all info about",
                alerts = Random.nextInt(0, 5),
                icon = R.mipmap.ic_battery
            )
        ),
    )

}