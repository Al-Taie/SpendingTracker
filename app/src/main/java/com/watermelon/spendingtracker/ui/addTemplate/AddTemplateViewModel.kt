package com.watermelon.spendingtracker.ui.addTemplate

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.watermelon.spendingtracker.model.data.Repository
import com.watermelon.spendingtracker.model.data.database.entities.Categories
import com.watermelon.spendingtracker.model.data.domain.Spending
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
        checkAndAddCategories()
        addSpendingType()
        loadCategories()
        loadSpendingType()
    }

    private fun checkAndAddCategories() {
        Repository.getAllCategory().subscribe {
            if (it.isNullOrEmpty())
                insertCategories()
        }
    }

    private fun insertCategories(){
        Repository.apply {
            subscribeData(insertCategory(Categories(0, "Home", IconsForCategories.Home )))
            subscribeData(insertCategory(Categories(0, "Transportation",  IconsForCategories.TRANSPORTATION )))
            subscribeData(insertCategory(Categories(0, "Food",  IconsForCategories.FOOD )))
            subscribeData(insertCategory(Categories(0, "Clothing", IconsForCategories.CLOTHING )))
            subscribeData(insertCategory(Categories(0, "Shopping",  IconsForCategories.SHOPPING )))
            subscribeData(insertCategory(Categories(0, "Cake",  IconsForCategories.CAKE )))
            subscribeData(insertCategory(Categories(0, "Office",  IconsForCategories.OFFICE )))
            subscribeData(insertCategory(Categories(0, "Entrainment",  IconsForCategories.ENTERTAINMENT )))
            subscribeData(insertCategory(Categories(0, "Car", IconsForCategories.CAR )))
            subscribeData(insertCategory(Categories(0, "Electronics", IconsForCategories.ELECTRONIC )))
            subscribeData(insertCategory(Categories(0, "Beauty",  IconsForCategories.BEAUTY )))
            subscribeData(insertCategory(Categories(0, "Telephone", IconsForCategories.TELEPHONE)))
            subscribeData(insertCategory(Categories(0, "Insurance", INSURANCE )))
            subscribeData(insertCategory(Categories(0, "Health",  IconsForCategories.HEALTH )))
            subscribeData(insertCategory(Categories(0, "Social",  IconsForCategories.SOCIAL )))
            subscribeData(insertCategory(Categories(0, "Cigarette",  IconsForCategories.CIGARETTE )))
            subscribeData(insertCategory(Categories(0, "Resturant",  IconsForCategories.RESTURANT )))
            subscribeData(insertCategory(Categories(0, "Gift", IconsForCategories.GIFT )))
            subscribeData(insertCategory(Categories(0, "Snacks",  IconsForCategories.SNACKS )))
            subscribeData(insertCategory(Categories(0, "Vegetables",  IconsForCategories.VEGETABLES )))
            subscribeData(insertCategory(Categories(0, "Book", IconsForCategories.BOOK )))
            subscribeData(insertCategory(Categories(0, "Fruits",  IconsForCategories.FRUITS )))
            subscribeData(insertCategory(Categories(0, "Pet",  IconsForCategories.PET )))
            subscribeData(insertCategory(Categories(0, "Baby",  IconsForCategories.BABY )))
            subscribeData(insertCategory(Categories(0, "Sport", IconsForCategories.SPORT )))
            subscribeData(insertCategory(Categories(0, "Education",  IconsForCategories.EDUCATION )))
            subscribeData(insertCategory(Categories(0, "Travel", IconsForCategories.TRAVEL )))
            subscribeData(insertCategory(Categories(0, "Other",  IconsForCategories.OTHER )))
        }
    }

    private fun addSpendingType() {
        Repository.getAllSpendingType().subscribe {
            if (it.isNullOrEmpty())
                insertSpendingType()
        }
    }

    private fun insertSpendingType(){
        Repository.apply {
            subscribeData(insertSpendingType(SpendingType(0, "Expenses")))
            subscribeData(insertSpendingType(SpendingType(1, "Income")))
        }
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


