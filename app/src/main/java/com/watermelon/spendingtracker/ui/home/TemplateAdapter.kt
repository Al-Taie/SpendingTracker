package com.watermelon.spendingtracker.ui.home

import com.watermelon.spendingtracker.R
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.model.data.database.relations.UserWithCategoriesAndSpending
import com.watermelon.spendingtracker.ui.base.BaseAdapter

class TemplateAdapter(list: List<Spending>, listener: TemplateInteractionListener) :
    BaseAdapter<Spending>(list, listener) {
    override val layoutID = R.layout.item_spending
}