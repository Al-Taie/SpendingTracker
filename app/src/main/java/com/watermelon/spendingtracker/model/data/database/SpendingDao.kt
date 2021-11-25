package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
//import com.watermelon.spendingtracker.model.data.domain.Spending
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface SpendingDao {
//    @Insert
//    fun insert(spending: Spending) : Completable
//
//    @Update
//    fun update(spending: Spending) : Completable
//
//    @Delete
//    fun delete(spending: Spending) : Completable

//    @Query("SELECT * FROM TB_SPENDING")
//    fun getAllSpending() : Observable<List<Spending>>


//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertUser(user: User)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertSalary(salary: Salary)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertCategories(categories: Categories)
//
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertUserCategoriesRelations(crossRef: UserCategoriesCrossRef)
//
//
//    @Transaction
//    @Query("SELECT * FROM User WHERE userName = :userName")
//    suspend fun getUserWithCategories(userName: String): List<UserWithCategories>
//
//    @Transaction
//    @Query("SELECT * FROM Categories WHERE categoriesName = :categories")
//    suspend fun getCategoriesWithUser(categories: String): List<CategoriesWithUser>
//
//
//    @Transaction
//    @Query("SELECT * FROM User")
//    suspend fun getUsersAndSalary(): List<UserWithSalary>
}