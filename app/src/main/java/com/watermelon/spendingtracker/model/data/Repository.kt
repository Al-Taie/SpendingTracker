package com.watermelon.spendingtracker.model.data

import android.util.Log
import com.watermelon.spendingtracker.model.data.database.SpendingDatabase
import com.watermelon.spendingtracker.model.data.database.entities.Categories
import com.watermelon.spendingtracker.model.data.database.entities.Salary
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.model.data.database.relations.UserCategoriesCrossRef
import com.watermelon.spendingtracker.model.data.domain.SpendingType
import com.watermelon.spendingtracker.utils.IconsForCategories.*
import com.watermelon.spendingtracker.utils.subscribeData

object Repository {
    private val spendingDao = SpendingDatabase.getInstance.spendDao
    private val userDao = SpendingDatabase.getInstance.userDao
    private val categoriesDao = SpendingDatabase.getInstance.categoriesDao

    private val spendingTypesDao = SpendingDatabase.getInstance.spendingTypesDao
    private val salaryDao = SpendingDatabase.getInstance.salaryDao

    fun insertUser(user: User) = userDao.insert(user)
    fun deleteUser(user: User) = userDao.delete(user)
    fun updateUser(user: User) = userDao.update(user)
    fun getAllUsers() = userDao.getAllUsers()
    fun getAllUsersWithCategories() = userDao.getAllUsersWithCategories()
    fun getUserWithCategoryWithSpending() = userDao.getUsersWithCategoryWithSpending()

    //    fun getUserWithSalary() = userDao.getUserWithSalary()
   // fun getUserSalary(userId: Long) = userDao.getUserSalary(userId)
    fun insertUserWithCategory(user: UserCategoriesCrossRef) = userDao.insertUserWithCategory(user)
    fun getUserWithSalary(userId: Long) = userDao.getUserWithSalary(userId)
    fun insertSalary(salary: Salary) = salaryDao.insert(salary)
    fun deleteSalary(salary: Salary) = salaryDao.delete(salary)
    fun updateSalary(salary: Salary) = salaryDao.update(salary)
    // fun getAllSalary() = salaryDao.getAllSalary()


    fun insertSpending(spending: Spending) = spendingDao.insert(spending)
    fun deleteSpending(spending: Spending) = spendingDao.delete(spending)
    fun updateSpending(spending: Spending) = spendingDao.update(spending)
    fun getAllSpending() = spendingDao.getAllSpending()

    fun insertSpendingType(spendingType: SpendingType) = spendingTypesDao.insert(spendingType)
    fun deleteSpendingType(spendingType: SpendingType) = spendingTypesDao.delete(spendingType)
    fun updateSpendingType(spendingType: SpendingType) = spendingTypesDao.update(spendingType)
    fun getAllSpendingType() = spendingTypesDao.getAllSpendingTypes()

    fun insertCategory(category: Categories) = categoriesDao.insert(category)
    fun deleteCategory(category: Categories) = categoriesDao.delete(category)
    fun updateCategory(category: Categories) = categoriesDao.update(category)
    fun getAllCategory() = categoriesDao.getAllCategory()

    fun insertSpendingType(){
        Repository.apply {
            insertSpendingType(SpendingType(0, "Expenses")).subscribeData()
            insertSpendingType(SpendingType(1, "Income")).subscribeData()
        }
    }


    fun insertCategories(){
        Repository.apply {
            Log.i("ssssssss" , "insert")
            insertCategory(Categories(0, "Home", Home)).subscribeData()
            insertCategory(Categories(0, "Transportation", TRANSPORTATION)).subscribeData()
            insertCategory(Categories(0, "Food", FOOD)).subscribeData()
            insertCategory(Categories(0, "Clothing", CLOTHING)).subscribeData()
            insertCategory(Categories(0, "Shopping", SHOPPING)).subscribeData()
            insertCategory(Categories(0, "Cake", CAKE)).subscribeData()
            insertCategory(Categories(0, "Office", OFFICE)).subscribeData()
            insertCategory(Categories(0, "Entrainment", ENTERTAINMENT)).subscribeData()
            insertCategory(Categories(0, "Car", CAR)).subscribeData()
            insertCategory(Categories(0, "Electronics", ELECTRONIC)).subscribeData()
            insertCategory(Categories(0, "Beauty", BEAUTY)).subscribeData()
            insertCategory(Categories(0, "Telephone", TELEPHONE)).subscribeData()
            insertCategory(Categories(0, "Insurance", INSURANCE)).subscribeData()
            insertCategory(Categories(0, "Health", HEALTH)).subscribeData()
            insertCategory(Categories(0, "Social", SOCIAL)).subscribeData()
            insertCategory(Categories(0, "Cigarette", CIGARETTE)).subscribeData()
            insertCategory(Categories(0, "Resturant", RESTURANT)).subscribeData()
            insertCategory(Categories(0, "Gift", GIFT)).subscribeData()
            insertCategory(Categories(0, "Snacks", SNACKS)).subscribeData()
            insertCategory(Categories(0, "Vegetables", VEGETABLES)).subscribeData()
            insertCategory(Categories(0, "Book", BOOK)).subscribeData()
            insertCategory(Categories(0, "Fruits", FRUITS)).subscribeData()
            insertCategory(Categories(0, "Pet", PET)).subscribeData()
            insertCategory(Categories(0, "Baby", BABY)).subscribeData()
            insertCategory(Categories(0, "Sport", SPORT)).subscribeData()
            insertCategory(Categories(0, "Education", EDUCATION)).subscribeData()
            insertCategory(Categories(0, "Travel", TRAVEL)).subscribeData()
            insertCategory(Categories(0, "Other", OTHER)).subscribeData()
         }
    }
}