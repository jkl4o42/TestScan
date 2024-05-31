package com.jkl.testscan.scan.di

import com.jkl.testscan.scan.data.DashboardDao
import com.jkl.testscan.scan.data.ScanRepositoryIml
import com.jkl.testscan.scan.domain.ScanInteractor
import com.jkl.testscan.scan.domain.ScanInteractorIml
import com.jkl.testscan.scan.domain.ScanRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ScanModule {

    @Provides
    fun provideScanRepository(dashboardDao: DashboardDao): ScanRepository =
        ScanRepositoryIml(dashboardDao)

    @Provides
    fun provideScanInteractor(scanRepository: ScanRepository): ScanInteractor =
        ScanInteractorIml(scanRepository)
}