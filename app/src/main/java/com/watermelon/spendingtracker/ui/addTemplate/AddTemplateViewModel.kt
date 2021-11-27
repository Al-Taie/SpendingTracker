package com.watermelon.spendingtracker.ui.addTemplate

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.watermelon.spendingtracker.model.data.Repository.getAllCategory
import com.watermelon.spendingtracker.model.data.Repository.insertCategories
import com.watermelon.spendingtracker.model.data.Repository.insertSpending
import com.watermelon.spendingtracker.model.data.database.entities.Category
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.ui.base.BaseViewModel
import com.watermelon.spendingtracker.utils.Constant.ERROR
import com.watermelon.spendingtracker.utils.subscribeData
import java.util.*


class AddTemplateViewModel : BaseViewModel(), TemplateInteractionListener, CategoriesInteractionListener {
    var amount = MutableLiveData<Double?>()
    var memo = MutableLiveData<String?>()
    var dateSpending = MutableLiveData<Date?>()
    var categories = MutableLiveData<List<Category>>()
    var description = MutableLiveData<String?>()
    private var categorySelected = MutableLiveData<Category?>(null)

    init {
        checkAndAddCategories()
        loadCategories()
    }

    private fun checkAndAddCategories() {
        observeData(getAllCategory(), {if (it.isNullOrEmpty()) insertCategories() }, {})
    }

    override fun onItemClicked() {
        checkAndInsertData()
    }

    private fun loadCategories() {
        observeData(
            getAllCategory(),
            { categories.postValue(it) }, this::onNotesFail
        )
    }


    private fun onNotesFail(error: Throwable) {
        Log.i(ERROR, error.message.toString())
    }


    fun checkAndInsertData(): Boolean =
        if (checkData()) {
            addSpending()
            true
        } else {
            Log.i("hhhhhh", amount.value.toString())
            false
        }

    private fun addSpending() {
        insertSpending(
            Spending(
                0,
                amount.value,
                "IQD",
                memo.value,
                description.value,
                Date(),
                categorySelected.value?.categoryName,
                categorySelected.value?.iconId,
            )
        ).subscribeData()
    }

    private fun checkData(): Boolean =
        (!memo.value.isNullOrEmpty() && !description.value.isNullOrEmpty() &&
                dateSpending.value != null && amount.value != null)

    override fun setSpendingDate(date: Date?) {
        date?.let { dateSpending.postValue(it) }
    }

    override fun onItemClicked(id: Category?) {
        id?.let { categorySelected.postValue(it) }
    }

}