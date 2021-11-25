package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.model.data.database.relations.SalaryOfUser
import com.watermelon.spendingtracker.model.data.database.relations.UserCategoriesCrossRef
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User) : Completable

    @Update
    fun update(user: User) : Completable

    @Delete
    fun delete(user: User) : Completable



    @Query("SELECT * FROM TB_USER")
    fun getAllUsers() : List<User>

    @Query("SELECT * FROM UserCategoriesCrossRef")
    fun getAllUsersWithCategories() : Observable<List<UserCategoriesCrossRef>>

    @Transaction
    @Query("SELECT * FROM TB_USER WHERE Name =:user")
    fun getUserWithSalary(user:String): Observable<List<SalaryOfUser>>

   @Transaction
    @Query("SELECT * FROM UserCategoriesCrossRef WHERE userName=:user and categoriesName=:c")
    fun getUserWithSalary(user:String,c:String): Observable<List<UserCategoriesCrossRef>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUserWithCategory(user: UserCategoriesCrossRef) : Completable

}