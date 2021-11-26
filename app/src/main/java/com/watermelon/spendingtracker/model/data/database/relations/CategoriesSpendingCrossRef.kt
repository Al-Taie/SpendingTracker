package com.watermelon.spendingtracker.model.data.database.relations

import androidx.room.Entity


@Entity(primaryKeys = ["categoriesId", "spendingId"])
data class CategoriesSpendingCrossRef(
    val categoriesId:Long,
    val spendingId:Long

)

