package com.watermelon.spendingtracker.ui.statistic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.model.data.database.relations.SalaryOfUser
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class StatisticViewModel : ViewModel() {

    private val repository = Repository

    val users = repository.getAllUsers()


    private val _selectedUsers = MediatorLiveData<User>()
    val selectedUsers: LiveData<User>
        get() = _selectedUsers







}
