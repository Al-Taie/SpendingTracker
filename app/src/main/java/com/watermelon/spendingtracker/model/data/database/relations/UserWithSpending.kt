package com.watermelon.spendingtracker.model.data.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.model.data.database.entities.Spending


data class UserWithSpending(

    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "spendingId"
    )
        val spending: List<Spending>

)
