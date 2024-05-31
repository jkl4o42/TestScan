package com.jkl.testscan.scan.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DashboardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg items: DashboardEntity)

    @Query("SELECT * FROM dashboard")
    suspend fun getAll(): List<DashboardEntity>
}