package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.domain.Spending
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface SpendingDao {
    @Insert
    fun insert(spending: Spending) : Completable

    @Update
    fun update(spending: Spending) : Completable

    @Delete
    fun delete(spending: Spending) : Completable

    @Query("SELECT * FROM TB_SPENDING")
    fun getAllSpending() : Observable<List<Spending>>
}