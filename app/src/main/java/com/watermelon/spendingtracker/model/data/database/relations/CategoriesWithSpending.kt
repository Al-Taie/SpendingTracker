package com.watermelon.spendingtracker.model.data.database.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.watermelon.spendingtracker.model.data.database.entities.Categories
import com.watermelon.spendingtracker.model.data.database.entities.Spending

data class CategoriesWithSpending(
    @Embedded val categories: Categories,
    @Relation(
        parentColumn = "categoriesId",
        entityColumn = "spendingId",
        associateBy = Junction(CategoriesSpendingCrossRef::class)
    )
    val spending: List<Spending>
)


