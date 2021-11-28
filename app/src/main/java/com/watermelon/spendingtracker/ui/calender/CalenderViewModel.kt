package com.watermelon.spendingtracker.ui.calender

import androidx.lifecycle.MutableLiveData
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.ui.base.BaseViewModel
import java.util.*

class CalenderViewModel : BaseViewModel(), CalenderInteractionListener {
    val spending = MutableLiveData<List<Spending>?>()

    init {
        showSpending(0L)
    }

    fun showSpending(date: Long) {
        observeData(Repository.getSpendingByDate(date), { spending.postValue(it) }, {})
    }
}