package com.jkl.testscan.scan.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DashboardEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun dashboardDao(): DashboardDao
}