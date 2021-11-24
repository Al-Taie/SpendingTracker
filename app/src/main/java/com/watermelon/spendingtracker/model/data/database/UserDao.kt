package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.model.data.database.relations.SalaryOfUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User) : Completable

    @Update
    fun update(user: User) : Completable

    @Delete
    fun delete(user: User) : Completable

//    @Query("SELECT * FROM TB_USER")
//    fun getAllUsers() : Observable<List<User>>


    @Transaction
    @Query("SELECT * FROM TB_USER WHERE userName =:user")
    fun getUserWithSalary(user:String): Observable<List<SalaryOfUser>>



}