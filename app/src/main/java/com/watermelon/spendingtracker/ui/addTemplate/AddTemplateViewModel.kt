package com.watermelon.spendingtracker.ui.addTemplate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.ui.base.BaseViewModel
import com.watermelon.spendingtracker.utils.subscribeData
import kotlinx.coroutines.launch
import java.util.*


class AddTemplateViewModel : BaseViewModel(), TemplateInteractionListener {
    var amount = MutableLiveData<Double?>()
    var currency = MutableLiveData<String>()
    var memo = MutableLiveData<String?>()
    var dateSpending = MutableLiveData<Date?>()
    var categories = MutableLiveData<List<Spending?>>()
    var description = MutableLiveData<String?>()

    fun addSpending() {

            Repository.insertSpending(Spending(
                0,
                amount.value,
                "IQD",
                memo.value,
                description.value,
                Date(),
                " categoriesName.",
                0)).subscribeData()


    }

    override fun onItemClick() {
        addSpending()
    }
}


//    private fun loadCategories() {
//            observeData(
//                getAllCategory(),
//                this::onGetCategories, this::onNotesFail
//            )
//    }
//
//    private fun onGetCategories(items: List<Categories>) {
//        categories.postValue(items)
//    }

//    private fun onNotesFail(error: Throwable) {
//        Log.i(ERROR, error.message.toString())
//    }
//
//
//    private fun loadSpendingType() {
//        observeData(getAllSpendingType(), this::onGetSpendingType, this::onSpendingTypeFail)
//    }
//
//    private fun onGetSpendingType(items: List<SpendingType>) {
//        spendingType.postValue(items)
//    }
//
//    private fun onSpendingTypeFail(error: Throwable) {
//        Log.i(ERROR, error.message.toString())
//    }

//    fun checkAndInsertData(): Boolean =
//        if (checkData()){
//            addSpending()
//            true
//        }else{
//            Log.i("hhhhhh" , amount.value.toString())
//            false
//        }

//    private fun addSpending() {
//        subscribeData(insertSpending(
//                Spending(0 ,0, categoriesSelected.value!!, amount.value!!.toDouble(),
//                    "IQD", memo.value!!, description.value!!, dateSpending.value!!)))
//    }

//    private fun checkData(): Boolean =
//        (!memo.value.isNullOrEmpty() && !description.value.isNullOrEmpty() &&
//                dateSpending.value != null && amount.value != null)

//    override fun setSpendingType(id: Int?) {
//        id?.let { spendingTypeSelected.postValue(it) }
//    }

//    override fun setSpendingDate(date: Date?) {
//        date?.let { dateSpending.postValue(it) }
//    }

//    override fun onClickCategories(id: Long?) {
//        id?.let { categoriesSelected.postValue(it) }
//    }




