package com.watermelon.spendingtracker.ui.addTemplate

import com.watermelon.spendingtracker.R
import com.watermelon.spendingtracker.model.data.domain.Category
import com.watermelon.spendingtracker.ui.base.BaseAdapter

class CategoriesAdapter(list: List<Category>, listener: CategoriesInteractionListener) :
    BaseAdapter<Category>(list, listener) {
    override val layoutID: Int
        get() = R.layout.item_category
}