package com.watermelon.spendingtracker.ui.addTemplate

import com.watermelon.spendingtracker.model.data.database.entities.Category
import com.watermelon.spendingtracker.ui.base.BaseInteractionListener

interface CategoriesInteractionListener : BaseInteractionListener {
    fun onItemClicked(id: Category?)
}