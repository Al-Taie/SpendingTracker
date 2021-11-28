package com.watermelon.spendingtracker.model.data

import com.watermelon.spendingtracker.model.data.database.SpendingDatabase
import com.watermelon.spendingtracker.model.data.database.entities.Category
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.utils.IconsForCategories
import com.watermelon.spendingtracker.utils.subscribeData

object Repository {
    private val spendingDao = SpendingDatabase.getInstance.spendDao
    private val categoriesDao = SpendingDatabase.getInstance.categoriesDao

    private fun insertCategory(category: Category) = categoriesDao.insert(category)
    fun insertCategories() {
        IconsForCategories.values().forEach {
            insertCategory(Category(0, it.title, it.iconID)).subscribeData()
        }
    }
    fun insertSpending(spending: Spending) = spendingDao.insert(spending)

    fun getAllSpending() = spendingDao.getAllSpending()
    fun getAllCategory() = categoriesDao.getAllCategory()
    fun getSumOfSpending() = spendingDao.getSumOfSpending()
    fun getAllUserCategoriesName() = spendingDao.getAllUserCategoriesName()
    fun getSpendingByDate(date: Long) = spendingDao.getSpendingByDate(date)
    fun getSumOfSpendingByCategoryName(categoryName: String) = spendingDao.getSumOfSpendingByCategoryName(categoryName)


}