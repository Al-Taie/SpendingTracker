package com.watermelon.spendingtracker.ui.statistic

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class StatisticViewModel : BaseViewModel(), StatisticInteractionListener {
    private val _spending = MutableLiveData<Double>()
    val spending = _spending.asFlow().asLiveData()
    val userCategories = MutableLiveData<Set<String>>()
    val chartData = MutableLiveData<List<Pair<String, Float>>?>(null)

    init {
        onItemClicked(1)
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

    private fun getSumOfSpending() =
        observeData(Repository.getSumOfSpending(), { _spending.postValue(it) }, {})


    override fun onItemClicked(id: Long) {
        getSumOfSpending()
    }
}
