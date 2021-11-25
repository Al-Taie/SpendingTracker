package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.database.entities.Categories
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface CategoriesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(category: Categories): Completable

    @Update
    fun update(category: Categories): Completable

    @Delete
    fun delete(category: Categories): Completable

    @Query("SELECT * FROM TB_CATEGORY")
    fun getAllCategory(): Observable<List<Categories>>



}