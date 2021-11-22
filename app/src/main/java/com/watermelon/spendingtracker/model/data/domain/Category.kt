package com.watermelon.spendingtracker.model.data.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_CATEGORY")
data class Category (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String
)