package com.jkl.testscan.main.di

import android.content.Context
import androidx.room.Room
import com.jkl.testscan.scan.data.AppDataBase
import com.jkl.testscan.scan.data.DashboardDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDataBase {
        return Room.databaseBuilder(
            appContext,
            AppDataBase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideDashboardDao(appDataBase: AppDataBase): DashboardDao = appDataBase.dashboardDao()
}