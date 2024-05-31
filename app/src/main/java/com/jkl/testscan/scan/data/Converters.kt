package com.jkl.testscan.scan.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromDashboardDetails(details: DashboardDetails): String {
        val gson = Gson()
        return gson.toJson(details)
    }

    @TypeConverter
    fun toDashboardDetails(detailsString: String): DashboardDetails {
        val gson = Gson()
        val type = object : TypeToken<DashboardDetails>() {}.type
        return gson.fromJson(detailsString, type)
    }
}