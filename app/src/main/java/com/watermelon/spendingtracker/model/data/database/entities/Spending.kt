package com.watermelon.spendingtracker.model.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "TB_SPENDING")
data class Spending(

    @PrimaryKey(autoGenerate = true)
    val spendingId: Long,
    // val userID: Long,
    // @ColumnInfo(name = "category_id")
    val categoryID: Long,
    val amount: Double,
    val currency: String, // IQD, USD
    val memo: String,
    val description: String,
    val date: Date
)