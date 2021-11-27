package com.watermelon.spendingtracker.model.data

import com.watermelon.spendingtracker.model.data.database.SpendingDatabase
import com.watermelon.spendingtracker.model.data.database.entities.Category
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.utils.IconsForCategories
import com.watermelon.spendingtracker.utils.subscribeData

object Repository {
    private val spendingDao = SpendingDatabase.getInstance.spendDao
    private val categoriesDao = SpendingDatabase.getInstance.categoriesDao

    fun getSumOfSpending() = spendingDao.getSumOfSpending()

    private fun insertCategory(category: Category) = categoriesDao.insert(category)


    fun insertSpending(spending: Spending) = spendingDao.insert(spending)
    fun deleteSpending(spending: Spending) = spendingDao.delete(spending)
    fun updateSpending(spending: Spending) = spendingDao.update(spending)
    fun getAllSpending() = spendingDao.getAllSpending()

    fun getAllCategory() = categoriesDao.getAllCategory()

    fun getAllUserCategoriesName() = spendingDao.getAllUserCategoriesName()

    fun getSumOfSpendingByCategoryName(categoryName: String) = spendingDao.getSumOfSpendingByCategoryName(categoryName)

    fun insertCategories() {
        IconsForCategories.values().forEach {
            insertCategory(Category(0, it.title, it.iconID)).subscribeData()
        }
    }
}