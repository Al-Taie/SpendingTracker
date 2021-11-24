package com.watermelon.spendingtracker.ui.addaccount

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.Salary
import com.watermelon.spendingtracker.model.data.database.entities.User

class AddAccountViewModel : ViewModel() {


    val userNameAccount = MutableLiveData<String>()

    val userSalary = MutableLiveData<String>()

    fun addUserAccount() {

        Repository.insertUser(
            User(0, userNameAccount.toString())
        )
        userNameAccount.postValue("")


        Repository.insertSalary(
            Salary(0, userSalary.toString())
        )
        userSalary.postValue("")
    }
}