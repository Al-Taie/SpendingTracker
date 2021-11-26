package com.watermelon.spendingtracker.ui.addaccount

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.Salary
import com.watermelon.spendingtracker.model.data.database.entities.User
import io.reactivex.rxjava3.schedulers.Schedulers

class AddAccountViewModel : ViewModel() {

    val userNameAccount = MutableLiveData<String>()
    val userSalary = MutableLiveData<String>()

    fun addUserAccount() {

        userNameAccount.value?.let {
            Repository.insertUser(
                User(0,it)
            )
                .subscribeOn(Schedulers.io())
                .subscribe()
        }
        userSalary.value?.let {
            Repository.insertSalary(
                Salary(0,
                    it,
                    userNameAccount.value.toString()
                )
            )
                .subscribeOn(Schedulers.io())
                .subscribe()
        }


        val getUserWithSalary = Repository.getUserWithSalary("Ammar")

        Log.i("userName", getUserWithSalary.toString())

    }
}