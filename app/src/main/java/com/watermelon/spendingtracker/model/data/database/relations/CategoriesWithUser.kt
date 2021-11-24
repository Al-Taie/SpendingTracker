package com.watermelon.spendingtracker.model.data.database.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.watermelon.spendingtracker.model.data.database.entities.User


//data class CategoriesWithUser(
//    @Embedded val categories: Categories,
//    @Relation(
//        parentColumn = "categoriesId",
//        entityColumn = "userId",
//        associateBy = Junction(UserCategoriesCrossRef::class)
//    )
//    val user: List<User>
//)