package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface SpendingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(spending: Spending) : Completable

    @Update
    fun update(spending: Spending) : Completable

    @Delete
    fun delete(spending: Spending) : Completable

    @Query("SELECT * FROM TB_SPENDING")
    fun getAllSpending() : Observable<List<Spending>>

    @Query("SELECT SUM(amount) FROM TB_SPENDING")
    fun getSumOfSpending(userID:Long):Observable<Spending>
}