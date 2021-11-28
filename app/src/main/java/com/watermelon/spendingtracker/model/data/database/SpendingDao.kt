package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow

@Dao
interface SpendingDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(spending: Spending): Completable

    @Update
    fun update(spending: Spending): Completable

    @Delete
    fun delete(spending: Spending): Completable

    @Query("SELECT * FROM TB_SPENDING")
    fun getAllSpending(): Observable<List<Spending>>

    @Query("SELECT SUM(amount) FROM TB_SPENDING")
    fun getSumOfSpending(): Observable<Double>

    @Query("SELECT SUM(amount) FROM TB_SPENDING WHERE categoryName = :categoryName")
    fun getSumOfSpendingByCategoryName(categoryName: String): Observable<Double>

    @Query("SELECT categoryName FROM TB_SPENDING")
    fun getAllUserCategoriesName() : Observable<List<String>>

    @Query("SELECT * FROM TB_SPENDING WHERE date >= :date")
    fun getSpendingByDate(date: Long): Observable<List<Spending>>
}