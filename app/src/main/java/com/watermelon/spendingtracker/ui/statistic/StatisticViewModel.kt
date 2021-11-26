package com.watermelon.spendingtracker.ui.statistic

import android.util.Log
import androidx.lifecycle.*
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.Salary
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.model.data.database.relations.SalaryOfUser
import com.watermelon.spendingtracker.model.data.database.relations.UserCategoriesCrossRef
import com.watermelon.spendingtracker.model.data.database.relations.UserWithCategoriesAndSpending
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class StatisticViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users = _users.asFlow().asLiveData()

    private val _salary = MutableLiveData<List<SalaryOfUser>>()
    val salary = _salary.asFlow().asLiveData()


    init {
        getAllUsers()
        getSalary(1)
    }

    private fun getAllUsers() {
        Repository.getAllUsers().observeOn(Schedulers.io())
            .subscribe({
                _users.postValue(it)
            }, {})

    }

    fun getSalary(id:Long){
        Repository.getUserWithSalary().observeOn(Schedulers.io())
            .subscribe({
                _salary.postValue(it)
            }, {})

        Log.i("hhhhhh",salary.value.toString())
    }
}
