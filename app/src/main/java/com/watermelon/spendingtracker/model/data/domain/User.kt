package com.watermelon.spendingtracker.model.data.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_USER")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val income: Double
)