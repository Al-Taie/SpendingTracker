package com.watermelon.spendingtracker.model.data

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun amountToString(value: Long) : String = value.toString()

    @TypeConverter
    fun amountToDouble(value: String) : Double = value.toDouble()

    @TypeConverter
    fun dateToLong(value: Date) : Long = value.time

    @TypeConverter
    fun longToDate(value: Long) : Date = Date(value)

}