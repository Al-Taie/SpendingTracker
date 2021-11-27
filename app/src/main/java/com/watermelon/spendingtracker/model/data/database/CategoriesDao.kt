package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.database.entities.Category
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category): Completable

    @Update
    fun update(category: Category): Completable

    @Delete
    fun delete(category: Category): Completable

    @Query("SELECT * FROM TB_CATEGORY")
    fun getAllCategory(): Observable<List<Category>>



}