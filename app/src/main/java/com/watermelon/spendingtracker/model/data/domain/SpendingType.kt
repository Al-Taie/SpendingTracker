package com.watermelon.spendingtracker.model.data.domain

import androidx.room.Entity

@Entity(tableName = "TB_SPENDING_TYPES")
data class SpendingType (
    val id: Int,
    val value: String
)