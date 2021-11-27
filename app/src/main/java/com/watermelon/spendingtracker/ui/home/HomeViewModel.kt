package com.watermelon.spendingtracker.ui.home

import androidx.lifecycle.MutableLiveData
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.ui.base.BaseViewModel

class HomeViewModel : BaseViewModel(), TemplateInteractionListener {

    val spending = MutableLiveData<List<Spending>?>()
   init {

       showSpending()
   }
    private fun showSpending() {
        observeData(Repository.getAllSpending(), {
            spending.postValue(it)
        }, {

        })
    }
}