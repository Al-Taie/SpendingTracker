package com.watermelon.spendingtracker.ui.statistic

import android.content.Context
import android.view.View
import android.widget.ArrayAdapter
import android.view.ViewGroup
import android.widget.Filterable
import com.watermelon.spendingtracker.model.data.database.entities.User

class CustomAdapter(
    context: Context?,
    resource: Int,
    private val objects: List<User>) : ArrayAdapter<String>(
    context!!, resource, objects.map { it.name }
), Filterable {
    private val fullList: List<String> = objects.map { it.name }

    var userID: Long = 0

    override fun getCount(): Int {
        return fullList.size
    }

    override fun getItem(position: Int): String {
        userID = objects[position].userId
        return fullList[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }

}