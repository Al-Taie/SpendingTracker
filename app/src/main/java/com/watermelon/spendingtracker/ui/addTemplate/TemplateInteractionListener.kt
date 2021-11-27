package com.watermelon.spendingtracker.ui.addTemplate

import java.util.*


interface TemplateInteractionListener {
    fun onItemClicked()
    fun setSpendingDate(date: Date?)
}