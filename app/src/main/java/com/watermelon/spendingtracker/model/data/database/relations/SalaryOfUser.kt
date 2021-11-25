package com.watermelon.spendingtracker.model.data.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.watermelon.spendingtracker.model.data.database.entities.Salary
import com.watermelon.spendingtracker.model.data.database.entities.User


data class SalaryOfUser(
    @Embedded val user: User,
    @Relation(
        parentColumn = "name",
        entityColumn = "salaryAmount"

    )
    val salary: Salary
)