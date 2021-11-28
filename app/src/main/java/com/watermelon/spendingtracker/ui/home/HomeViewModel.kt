package com.watermelon.spendingtracker.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.ui.base.BaseViewModel

class HomeViewModel : BaseViewModel(), TemplateInteractionListener {
    private val _sumOfSpending = MutableLiveData<Double>()
    val sumOfSpending = _sumOfSpending.asFlow().asLiveData()
    val spending = MutableLiveData<List<Spending>?>()
    val userCategories = MutableLiveData<Set<String>>()
    val chartData = MutableLiveData<List<Pair<String, Float>>?>(null)

   init {
       showSpending()
       getSumOfSpending()
       initChart()
   }

    private fun initChart() {
        observeData(
            Repository.getAllUserCategoriesName(),
            { userCategories.postValue(it.toSet()) },
            {})
    }

    fun getSumOfSpendingByCategory() {
        val categoriesWithSpending = mutableListOf<Pair<String, Float>>()
        userCategories.value?.forEach { categoryName ->
            observeData(Repository.getSumOfSpendingByCategoryName(categoryName), {
                categoriesWithSpending.add(Pair(categoryName, it.toFloat()))
                chartData.postValue(categoriesWithSpending)
            }, {})
        }
    }

    private fun showSpending() {
        observeData(Repository.getAllSpending(), {
            spending.postValue(it)
        }, {

        })
    }

    private fun getSumOfSpending() =
        observeData(Repository.getSumOfSpending(), { _sumOfSpending.postValue(it) }, {})
}