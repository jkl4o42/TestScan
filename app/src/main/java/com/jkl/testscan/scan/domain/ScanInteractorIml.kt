package com.jkl.testscan.scan.domain

import com.jkl.testscan.scan.data.DashboardEntity

class ScanInteractorIml(
    private val scanRepository: ScanRepository
): ScanInteractor {
    override suspend fun dashboard(): List<DashboardEntity> = scanRepository.dashboard()
    override suspend fun insertAll(list: List<DashboardEntity>) = scanRepository.insertAll(list)
}