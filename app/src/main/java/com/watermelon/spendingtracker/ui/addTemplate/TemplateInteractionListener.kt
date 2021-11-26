package com.watermelon.spendingtracker.ui.addTemplate

import java.util.*


interface TemplateInteractionListener {
    fun  setSpendingType(id: Int?)
    fun  setSpendingDate(date: Date?)
}