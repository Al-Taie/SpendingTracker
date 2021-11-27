package com.watermelon.spendingtracker.model.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_CATEGORY")

data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryId:Long,
    val categoryName: String,
    val iconId: Int
)