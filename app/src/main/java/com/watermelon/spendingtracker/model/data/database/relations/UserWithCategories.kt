package com.watermelon.spendingtracker.model.data.database.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.watermelon.spendingtracker.model.data.database.entities.User

//data class UserWithCategories(
//    @Embedded val user: User,
//    @Relation(
//        parentColumn = "userId",
//        entityColumn = "categoriesId",
//        associateBy = Junction(UserCategoriesCrossRef::class)
//    )
//    val categories: List<Categories>
//)
