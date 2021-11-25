package com.watermelon.spendingtracker.model.data.database

import androidx.room.*
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.model.data.database.relations.SalaryOfUser
import com.watermelon.spendingtracker.model.data.database.relations.UserWithSpending
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User): Completable

    @Update
    fun update(user: User): Completable

    @Delete
    fun delete(user: User): Completable

//    @Query("SELECT * FROM TB_USER")
//    fun getAllUsers() : Observable<List<User>>


    @Transaction
    @Query("SELECT * FROM TB_USER WHERE Name =:user")
    fun getUserWithSalary(user: String): Observable<List<SalaryOfUser>>

    //    @Query("select accounts.id as accountId," +
//            "from accounts inner join currencies on accounts.currencyId=currencies.id")
//    fun getAll():LiveData<Array<AccountModel>>
    @Transaction
    @Query("SELECT * FROM TB_USER inner join TB_SALARY WHERE id = salaryId")
    fun getUserWithSalaryTwo(): Observable<List<SalaryOfUser>>

    @Transaction
    @Query("SELECT * FROM TB_USER inner join TB_SPENDING WHERE id =userID")
    fun getUserWithSpending(): Observable<List<UserWithSpending>>
}