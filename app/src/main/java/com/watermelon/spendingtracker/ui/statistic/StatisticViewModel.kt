package com.watermelon.spendingtracker.ui.statistic

import androidx.lifecycle.*
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.model.data.database.relations.SalaryOfUser
import com.watermelon.spendingtracker.model.data.database.relations.UserCategoriesCrossRef
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class StatisticViewModel : ViewModel() {
    private val _users = MutableLiveData<List<UserCategoriesCrossRef>>()
    val users = _users.asFlow().asLiveData()

    init {
        getAllUsers()
    }

    private fun getAllUsers() {
        Repository.getAllUsersWithCategories().observeOn(Schedulers.io())
            .subscribe({
                _users.postValue(it)
            }, {})
    }
}
