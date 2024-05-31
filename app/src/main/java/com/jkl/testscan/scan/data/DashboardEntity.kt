package com.jkl.testscan.scan.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "dashboard")
@TypeConverters(Converters::class)
data class DashboardEntity(
    @PrimaryKey val type: String,
    val details: DashboardDetails
)