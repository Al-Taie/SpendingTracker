package com.watermelon.spendingtracker.ui.calender

import com.watermelon.spendingtracker.R
import com.watermelon.spendingtracker.model.data.database.entities.Spending
import com.watermelon.spendingtracker.ui.base.BaseAdapter

class CalenderAdapter(list: List<Spending>, listener: CalenderInteractionListener) :
    BaseAdapter<Spending>(list, listener) {
    override val layoutID: Int
        get() = R.layout.item_single_expense
}