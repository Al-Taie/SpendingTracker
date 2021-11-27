package com.watermelon.spendingtracker.model.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.watermelon.spendingtracker.utils.IconsForCategories

@Entity(tableName = "TB_CATEGORY")

data class Categories(
    @PrimaryKey(autoGenerate = true)
    val categoriesId:Long,
    val categoriesName: String,
    val iconId: Int
)