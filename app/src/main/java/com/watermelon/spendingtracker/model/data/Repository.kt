package com.watermelon.spendingtracker.model.data

import com.watermelon.spendingtracker.model.data.database.SpendingDatabase
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.utils.IconsForCategories

object Repository {
    private val spendingDao = SpendingDatabase.getInstance.spendDao





    //    fun getUserWithSalary() = userDao.getUserWithSalary()
    // fun getUserSalary(userId: Long) = userDao.getUserSalary(userId)
//    fun insertUserWithCategory(user: UserCategoriesCrossRef) = userDao.insertUserWithCategory(user)
//    fun getUserWithSalary(userId: Long) = userDao.getUserWithSalary(userId)
//    fun insertSalary(salary: Salary) = salaryDao.insert(salary)
//    fun deleteSalary(salary: Salary) = salaryDao.delete(salary)
//    fun updateSalary(salary: Salary) = salaryDao.update(salary)
    // fun getAllSalary() = salaryDao.getAllSalary()

    fun getSumOfSpending() = spendingDao.getSumOfSpending()

    fun insertSpending(spending: Spending) = spendingDao.insert(spending)
    fun deleteSpending(spending: Spending) = spendingDao.delete(spending)
    fun updateSpending(spending: Spending) = spendingDao.update(spending)
    fun getAllSpending() = spendingDao.getAllSpending()

//
//    fun insertCategories() {
//        IconsForCategories.values().forEach {
//            insertCategory(Categories(0, it.title, it.iconID)).subscribeData()
//        }
//    }
}