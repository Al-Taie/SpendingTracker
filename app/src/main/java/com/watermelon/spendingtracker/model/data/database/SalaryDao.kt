package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.database.entities.Salary
import com.watermelon.spendingtracker.model.data.database.entities.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface SalaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(salary: Salary) : Completable

    @Update
    fun update(salary: Salary) : Completable

    @Delete
    fun delete(salary: Salary) : Completable

    @Query("SELECT * FROM TB_SALARY")
    fun getAllSalary() : Observable<List<Salary>>


}