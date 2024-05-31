package com.jkl.testscan.scan.data

import com.jkl.testscan.scan.domain.ScanRepository

class ScanRepositoryIml(
    private val dashboardDao: DashboardDao
) : ScanRepository {
    override suspend fun dashboard(): List<DashboardEntity> = dashboardDao.getAll()
    override suspend fun insertAll(list: List<DashboardEntity>) = dashboardDao.insertAll(*list.toTypedArray())
}