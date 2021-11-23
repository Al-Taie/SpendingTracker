package com.watermelon.spendingtracker.ui.addTemplate

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.domain.Category
import com.watermelon.spendingtracker.model.data.domain.Spending
import com.watermelon.spendingtracker.model.data.domain.SpendingType
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*


class AddTemplateViewModel : ViewModel(), TemplateInteractionListener,
    CategoriesInteractionListener {

    var categories = MutableLiveData<List<Category>>()
    var spendingType = MutableLiveData<List<SpendingType>>()

    var spendingTypeSelected = MutableLiveData(0)
    private var categoriesSelected = MutableLiveData<Long>(1)
    var amount = MutableLiveData<String?>()
    var currency = MutableLiveData<String>()
    var memo = MutableLiveData<String?>()
    var dateSpending = MutableLiveData<String?>()
    var description = MutableLiveData<String?>()

    init {
        loadSpendingType()
        loadCategories()
    }

    private fun loadCategories() {
        Repository
            .getAllCategory()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(this::onGetCategories, this::onNotesFail)
    }

    private fun onGetCategories(items: List<Category>) {
        categories.postValue(items)
    }

    private fun onNotesFail(error: Throwable) {}


    private fun loadSpendingType() {
        Repository
            .getAllSpendingType()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                this::onGetSpendingType,
                this::onNotesFail
            )
    }

    private fun onGetSpendingType(items: List<SpendingType>) {
        spendingType.postValue(items)
    }

    private fun onSpendingTypeFail(error: Throwable) {}

    fun addSpending() {
        if (checkData()) {
            Repository.insertSpending(
                Spending(0, categoriesSelected.value!!, amount.value!!.toLong(),
                    "IQD", memo.value!!, description.value!!, Date(dateSpending.value)
                ))
        }else {
            Log.i("ssssss" , "erroe")
        }
    }

    fun checkData(): Boolean =
        (!memo.value.isNullOrEmpty() && !description.value.isNullOrEmpty() &&
                !dateSpending.value.isNullOrEmpty() && !amount.value.isNullOrEmpty())

    override fun setSpendingType(id: Int?) {
        id?.let {
            spendingTypeSelected.postValue(it)
        }
    }

    override fun setSpendingDate(date: String?) {
        date?.let {
            dateSpending.postValue(it)
        }
    }

    override fun onClickCategories(id: Long?) {
        id?.let {
            categoriesSelected.postValue(it)
        }
    }


}


