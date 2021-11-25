package com.watermelon.spendingtracker.ui.home

import com.watermelon.spendingtracker.R
import com.watermelon.spendingtracker.model.data.database.relations.UserCategoriesCrossRef
import com.watermelon.spendingtracker.ui.base.BaseAdapter

class TemplateAdapter(list: List<UserCategoriesCrossRef>, listener: TemplateInteractionListener) :
    BaseAdapter<UserCategoriesCrossRef>(list, listener) {
    override val layoutID = R.layout.item_expenses
}