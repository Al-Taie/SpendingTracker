package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.domain.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface UserDao {
    @Insert
    fun insert(user: User) : Completable

    @Update
    fun update(user: User) : Completable

    @Delete
    fun delete(user: User) : Completable

    @Query("SELECT * FROM TB_USER")
    fun getAllUsers() : Observable<List<User>>
}