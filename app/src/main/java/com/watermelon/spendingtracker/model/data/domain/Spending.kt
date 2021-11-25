package com.watermelon.spendingtracker.model.data.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "TB_SPENDING")
data class Spending(

    @PrimaryKey(autoGenerate = true)
    val userID: Long,
   // @ColumnInfo(name = "category_id")
    val categoryID: Long,
    val amount: Long,
    val currency: String, // IQD, USD
    val memo: String,
    val description: String,
    val date: Date
)