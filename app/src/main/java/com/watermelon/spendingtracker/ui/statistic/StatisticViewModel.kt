package com.watermelon.spendingtracker.ui.statistic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.ui.base.BaseViewModel

class StatisticViewModel : BaseViewModel(), StatisticInteractionListener {
    private val _spending = MutableLiveData<Double>()
    val spending = _spending.asFlow().asLiveData()
    private val userCategories = MutableLiveData<Set<String>>()


    init {
        onItemClicked(1)
    }


    fun initChart() {
        observeData(
            Repository.getAllUserCategoriesName(),
            { userCategories.postValue(it.toSet()) },
            {})

        userCategories.value?.forEach {

        }
    }

    private fun getSumOfSpending() =
        observeData(Repository.getSumOfSpending(), { _spending.postValue(it) }, {})


    override fun onItemClicked(id: Long) {
        getSumOfSpending()
    }
}
