package com.watermelon.spendingtracker.ui.addTemplate

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.watermelon.spendingtracker.model.data.Repository.getAllCategory
import com.watermelon.spendingtracker.model.data.Repository.getAllSpendingType
import com.watermelon.spendingtracker.model.data.Repository.insertCategories
import com.watermelon.spendingtracker.model.data.Repository.insertSpending
import com.watermelon.spendingtracker.model.data.Repository.insertSpendingType
import com.watermelon.spendingtracker.model.data.database.entities.Categories
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.model.data.domain.SpendingType
import com.watermelon.spendingtracker.ui.base.BaseViewModel
import com.watermelon.spendingtracker.utils.Constant.ERROR
import java.util.*


class AddTemplateViewModel : BaseViewModel(), TemplateInteractionListener,
    CategoriesInteractionListener {

    var categories = MutableLiveData<List<Categories>>()
    var spendingType = MutableLiveData<List<SpendingType>>()
    val isExistData = MutableLiveData<Boolean?>()

    var spendingTypeSelected = MutableLiveData(0)
    private var categoriesSelected = MutableLiveData<Long>(0)
    var amount = MutableLiveData<String?>()
    var currency = MutableLiveData<String>()
    var memo = MutableLiveData<String?>()
    var dateSpending = MutableLiveData<Date?>()
    var description = MutableLiveData<String?>()


    init {
        checkAndAddCategories()
        checkAndAddSpendingType()
        loadCategories()
        loadSpendingType()
    }


    private fun checkAndAddCategories() {
        getAllCategory().subscribe {
            if (it.isNullOrEmpty())
                insertCategories()
        }
    }

    private fun checkAndAddSpendingType() {
        getAllSpendingType().subscribe {
            if (it.isNullOrEmpty())
                insertSpendingType()
        }
    }

    private fun loadCategories() {
            observeData(
                getAllCategory(),
                this::onGetCategories, this::onNotesFail
            )
    }

    private fun onGetCategories(items: List<Categories>) {
        categories.postValue(items)
    }

    private fun onNotesFail(error: Throwable) {
        Log.i(ERROR, error.message.toString())
    }


    private fun loadSpendingType() {
        observeData(getAllSpendingType(), this::onGetSpendingType, this::onSpendingTypeFail)
    }

    private fun onGetSpendingType(items: List<SpendingType>) {
        spendingType.postValue(items)
    }

    private fun onSpendingTypeFail(error: Throwable) {
        Log.i(ERROR, error.message.toString())
    }

    fun checkAndInsertData(): Boolean =
        if (checkData()){
            addSpending()
            true
        }else{
            false
        }

    fun addSpending() {
        subscribeData(insertSpending(
                Spending(0 ,0, categoriesSelected.value!!, amount.value!!.toDouble(),
                    "IQD", memo.value!!, description.value!!, dateSpending.value!!)))
    }

    fun checkData(): Boolean =
        (!memo.value.isNullOrEmpty() && !description.value.isNullOrEmpty() &&
                dateSpending.value != null && !amount.value.isNullOrEmpty())

    override fun setSpendingType(id: Int?) {
        id?.let { spendingTypeSelected.postValue(it) }
    }

    override fun setSpendingDate(date: Date?) {
        date?.let { dateSpending.postValue(it) }
    }

    override fun onClickCategories(id: Long?) {
        id?.let { categoriesSelected.postValue(it) }
    }

}


