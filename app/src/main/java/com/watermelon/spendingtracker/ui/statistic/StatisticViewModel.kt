package com.watermelon.spendingtracker.ui.statistic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.ui.base.BaseViewModel

class StatisticViewModel : BaseViewModel(), StatisticInteractionListener {

    private val _spending = MutableLiveData<Double>()
    var spending = _spending.asFlow().asLiveData()


    init {
        onItemClicked(1)
    }


    private fun getSumOfSpending() =
        observeData(Repository.getSumOfSpending(), { _spending.postValue(it) }, {})


    override fun onItemClicked(id: Long) {
        getSumOfSpending()
    }
}
