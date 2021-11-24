package com.watermelon.spendingtracker.model.data

import com.watermelon.spendingtracker.model.data.database.SpendingDatabase
import com.watermelon.spendingtracker.model.data.database.entities.Salary
import com.watermelon.spendingtracker.model.data.database.entities.User

//import com.watermelon.spendingtracker.model.data.domain.Spending
//import com.watermelon.spendingtracker.model.data.domain.SpendingType

object Repository {
    //private val spendingDao = SpendingDatabase.getInstance.spendDao
    private val userDao = SpendingDatabase.getInstance.userDao
   // private val categoryDao = SpendingDatabase.getInstance.categoryDao

    //private val spendingTypesDao = SpendingDatabase.getInstance.spendingTypesDao
    private val salaryDao = SpendingDatabase.getInstance.salaryDao

    fun insertUser(user: User) = userDao.insert(user)
    fun deleteUser(user: User) = userDao.delete(user)
    fun updateUser(user: User) = userDao.update(user)
    fun getAllUsers() = userDao.getAllUsers()

    fun insertSalary(salary: Salary) = salaryDao.insert(salary)
    fun deleteSalary(salary: Salary) = salaryDao.delete(salary)
    fun updateSalary(salary: Salary) = salaryDao.update(salary)
    fun getAllSalary() = salaryDao.getAllSalary()

//    fun insertSpending(spending: Spending) = spendingDao.insert(spending)
//    fun deleteSpending(spending: Spending) = spendingDao.delete(spending)
//    fun updateSpending(spending: Spending) = spendingDao.update(spending)
    // fun getAllSpending() = spendingDao.getAllSpending()

//    fun insertSpendingType(spendingType: SpendingType) = spendingTypesDao.insert(spendingType)
//    fun deleteSpendingType(spendingType: SpendingType) = spendingTypesDao.delete(spendingType)
//    fun updateSpendingType(spendingType: SpendingType) = spendingTypesDao.update(spendingType)
    //  fun getAllSpendingType() = spendingTypesDao.getAllSpendingTypes()
//
//    fun insertCategory(category: Categories) = categoryDao.insert(category)
//    fun deleteCategory(category: Categories) = categoryDao.delete(category)
//    fun updateCategory(category: Categories) = categoryDao.update(category)
//    fun getAllCategory() = categoryDao.getAllCategory()
}