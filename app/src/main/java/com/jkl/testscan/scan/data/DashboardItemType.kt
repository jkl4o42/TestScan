package com.jkl.testscan.scan.data

sealed class DashboardItemType {
    data object DeviceInfo : DashboardItemType()
    data object CalibrationOfSensors : DashboardItemType()
    data object AppMonitoring : DashboardItemType()
    data object AntiVirus : DashboardItemType()
    data object DeviceMemoryInformation : DashboardItemType()
    data object FileManager : DashboardItemType()
    data object BatteryInfo : DashboardItemType()
}