package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.database.entities.Salary
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.model.data.database.relations.SalaryOfUser
import com.watermelon.spendingtracker.model.data.database.relations.UserWithCategoriesAndSpending
import com.watermelon.spendingtracker.model.data.database.relations.UserWithSpending
import com.watermelon.spendingtracker.model.data.database.relations.UserCategoriesCrossRef
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User): Completable

    @Update
    fun update(user: User): Completable

    @Delete
    fun delete(user: User): Completable

    @Query("SELECT * FROM TB_USER WHERE userId==:id")
    fun getUserById(id :Long?): Observable<User>


    @Transaction
    @Query("SELECT * FROM TB_USER")
    fun getUsers():Observable< List<UserWithCategoriesAndSpending>>

    @Query("SELECT * FROM TB_USER")
    fun getAllUsers() : Observable<List<User>>

    @Transaction
    @Query("SELECT * FROM TB_USER,TB_CATEGORY,TB_SPENDING")
    fun getUsersWithCategoryWithSpending(): Observable<List<UserWithCategoriesAndSpending>>


    @Query("SELECT * FROM UserCategoriesCrossRef")
    fun getAllUsersWithCategories() : Observable<List<UserCategoriesCrossRef>>


//   @Transaction
//    @Query("SELECT * FROM  TB_USER inner join TB_SALARY WHERE salaryId=:userid")
//    fun getUserSalary(userid: Long): Observable<List<SalaryOfUser>>

    @Transaction
    @Query("SELECT * FROM TB_SALARY  WHERE SalaryId = :userid")
    fun getUserWithSalary(userid: Long): Observable<List<Salary>>

//   @Transaction
//    @Query("SELECT * FROM UserCategoriesCrossRef WHERE userName=:user and categoriesName=:c")
//    fun getUserWithSalary(user:String,c:String): Observable<List<UserCategoriesCrossRef>>

    @Transaction
    @Query("SELECT * FROM TB_USER inner join TB_SPENDING WHERE userId =spendingId")
    fun getUserWithSpending(): Observable<List<UserWithSpending>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUserWithCategory(user: UserCategoriesCrossRef) : Completable

}