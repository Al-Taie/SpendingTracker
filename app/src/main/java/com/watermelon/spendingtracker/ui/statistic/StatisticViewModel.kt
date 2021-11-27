package com.watermelon.spendingtracker.ui.statistic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.Salary
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.ui.base.BaseViewModel
import io.reactivex.rxjava3.schedulers.Schedulers

class StatisticViewModel : BaseViewModel(), StatisticInteractionListener {
    private val _users = MutableLiveData<List<User>>()
    val users = _users.asFlow().asLiveData()

    private val _salary = MutableLiveData<Salary>()
    var salary = _salary.asFlow().asLiveData()

    private val _spending= MutableLiveData<Double>()
    var spending = _spending.asFlow().asLiveData()


    init {
        getAllUsers()
        onItemClicked(1)
    }

    private fun getAllUsers() = observeData(Repository.getAllUsers(), { _users.postValue(it) }, {})

    private fun getSalary(userID: Long) =
        observeData(Repository.getUserWithSalary(userID), { _salary.postValue(it) }, {})
    }

    private fun getSalary(userID: Long){
        Repository.getUserWithSalary(userID).observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _salary.postValue(it)
            }, {})
    }

    private fun getSumOfSpending(userID: Long){
        Repository.getSumOfSpending(userID).observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _spending.postValue(it)
            }, {})
    }

    override fun onItemClicked(id: Long) {
        getSalary(id)
        getSumOfSpending(id)
    }
}
