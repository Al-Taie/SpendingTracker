package com.watermelon.spendingtracker.model.data.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.watermelon.spendingtracker.model.data.database.entities.Categories
import com.watermelon.spendingtracker.model.data.database.entities.User

data class UserWithCategoriesAndSpending(
    @Embedded val user: User,
    @Relation(
        entity = Categories::class,
        parentColumn = "userId",
        entityColumn = "categoriesId",

    )
    val categories: List<CategoriesWithSpending>
    )
