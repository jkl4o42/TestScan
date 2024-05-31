package com.jkl.testscan.scan.domain

import com.jkl.testscan.scan.data.DashboardEntity

interface ScanRepository {
    suspend fun dashboard(): List<DashboardEntity>
    suspend fun insertAll(list: List<DashboardEntity>)
}