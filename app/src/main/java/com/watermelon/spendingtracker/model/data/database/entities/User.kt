package com.watermelon.spendingtracker.model.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_USER")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Long,
    val userName: String,
   // val userSalary:Long
)