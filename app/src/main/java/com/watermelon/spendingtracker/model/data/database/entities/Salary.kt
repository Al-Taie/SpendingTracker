package com.watermelon.spendingtracker.model.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_SALARY")
data class Salary(
    @PrimaryKey(autoGenerate = true)
    val salaryId:Long,
    val salaryAmount: String,
    val userName:String,


)
