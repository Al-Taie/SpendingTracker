package com.watermelon.spendingtracker.model.data.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_SPENDING_TYPES")
data class SpendingType (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val value: String
)