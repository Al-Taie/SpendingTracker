package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.domain.SpendingType
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface SpendingTypesDao {
    @Insert
    fun insert(spendingType: SpendingType) : Completable

    @Update
    fun update(spendingType: SpendingType) : Completable

    @Delete
    fun delete(spendingType: SpendingType) : Completable

    @Query("SELECT * FROM TB_SPENDING_TYPES")
    fun getAllSpendingTypes() : Observable<List<SpendingType>>
}