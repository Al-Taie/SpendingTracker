package com.watermelon.spendingtracker.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.relations.UserCategoriesCrossRef
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : ViewModel(), TemplateInteractionListener {
    val expense = MutableLiveData<String>()
    private val _users = MutableLiveData<List<UserCategoriesCrossRef>>()
    val users = _users.asFlow().asLiveData()

    init {
        addExpense()
        getAllUsers()
    }

    private fun addExpense() {
        Repository.insertUserWithCategory(UserCategoriesCrossRef(5, "Tanager", 1, "Test"))
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    fun getAllUsers() {
        Repository.getAllUsersWithCategories().observeOn(Schedulers.io())
            .subscribe({
                _users.postValue(it)
            }, {})
    }
}