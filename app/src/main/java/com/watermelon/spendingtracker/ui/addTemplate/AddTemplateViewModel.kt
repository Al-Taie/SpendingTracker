package com.watermelon.spendingtracker.ui.addTemplate

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.Categories
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.model.data.domain.SpendingType
import com.watermelon.spendingtracker.ui.base.BaseViewModel
import com.watermelon.spendingtracker.utils.Constant.ERROR
import com.watermelon.spendingtracker.utils.IconsForCategories
import com.watermelon.spendingtracker.utils.IconsForCategories.INSURANCE
import java.util.*


class AddTemplateViewModel : BaseViewModel(), TemplateInteractionListener,
    CategoriesInteractionListener {

    var categories = MutableLiveData<List<Categories>>()
    var spendingType = MutableLiveData<List<SpendingType>>()

    var spendingTypeSelected = MutableLiveData(0)
    private var categoriesSelected = MutableLiveData<Long>(1)
    var amount = MutableLiveData<String?>()
    var currency = MutableLiveData<String>()
    var memo = MutableLiveData<String?>()
    var dateSpending = MutableLiveData<String?>()
    var description = MutableLiveData<String?>()


    init {
        loadCategories()
        loadSpendingType()
    }


    private fun loadCategories() {
        observeData(Repository.getAllCategory(),
            this::onGetCategories, this::onNotesFail)
    }

    private fun onGetCategories(items: List<Categories>) {
        categories.postValue(items)
    }

    private fun onNotesFail(error: Throwable) { Log.i(ERROR , error.message.toString()) }


    private fun loadSpendingType() {
        observeData(Repository.getAllSpendingType(),
            this::onGetSpendingType, this::onSpendingTypeFail)
    }

    private fun onGetSpendingType(items: List<SpendingType>) {
        spendingType.postValue(items)
    }

    private fun onSpendingTypeFail(error: Throwable) { Log.i(ERROR , error.message.toString()) }

    fun addSpending() {
        if (checkData()) {
           subscribeData( Repository.insertSpending(
                Spending(0, categoriesSelected.value!!, amount.value!!.toDouble(),
                    "IQD", memo.value!!, description.value!!, Date(dateSpending.value))))

            Log.i("haha",Repository.insertSpending( Spending(0, categoriesSelected.value!!, amount.value!!.toDouble(),
                "IQD", memo.value!!, description.value!!, Date(dateSpending.value))).toString())
        }
    }

    private fun checkData(): Boolean =
        (!memo.value.isNullOrEmpty() && !description.value.isNullOrEmpty() &&
                !dateSpending.value.isNullOrEmpty() && !amount.value.isNullOrEmpty())

    override fun setSpendingType(id: Int?) {
        id?.let { spendingTypeSelected.postValue(it) }
    }

    override fun setSpendingDate(date: String?) {
        date?.let { dateSpending.postValue(it) }
    }

    override fun onClickCategories(id: Long?) {
        id?.let { categoriesSelected.postValue(it) }
    }

}


