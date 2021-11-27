package com.watermelon.spendingtracker.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.relations.UserCategoriesCrossRef
import com.watermelon.spendingtracker.ui.base.BaseViewModel
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : BaseViewModel(), TemplateInteractionListener {
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

    private fun getAllUsers() =
        observeData(Repository.getAllUsersWithCategories(), { _users.postValue(it) }, {})

}