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

   init {
       showSpending()
       getSumOfSpending()
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