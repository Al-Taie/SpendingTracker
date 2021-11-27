package com.watermelon.spendingtracker.utils

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.watermelon.spendingtracker.R
import com.watermelon.spendingtracker.ui.addTemplate.CategoriesInteractionListener
import com.watermelon.spendingtracker.ui.addTemplate.TemplateInteractionListener
import com.watermelon.spendingtracker.ui.base.BaseAdapter
import java.util.*

import androidx.databinding.InverseBindingAdapter

import androidx.databinding.InverseBindingListener
import com.watermelon.spendingtracker.model.data.database.entities.Category
import java.text.SimpleDateFormat


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView?, items: List<T>?) {
    (view?.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}



@SuppressLint("ResourceAsColor")
@BindingAdapter(value = ["app:selectedItem", "app:listener", "app:stream"])
fun onClickSelectedItem(
    view: View, selectedItem: ShapeableImageView?,
    listener: CategoriesInteractionListener, item: Category?
) {
    view.setOnClickListener {
            selectedItem?.setBackgroundColor(R.color.base_color)
            selectedItem?.setColorFilter(ContextCompat.getColor(view.context, R.color.white))
            listener.onItemClicked(item)
    }

}


@SuppressLint("SimpleDateFormat")
@BindingAdapter(value = ["app:listenerDate"])
fun setDateCalender(view: ImageView, listener: TemplateInteractionListener) {
    val calender: Calendar = Calendar.getInstance()
    var dayCal = calender.get(Calendar.DAY_OF_WEEK)
    var monthCal = calender.get(Calendar.MONTH)
    var yearCal = calender.get(Calendar.YEAR)

    view.setOnClickListener {
        DatePickerDialog(view.context, { _, year, monthOfYear, dayOfMonth ->
            calender.set(year, monthOfYear, dayOfMonth)
            yearCal = year
            monthCal = monthOfYear
            dayCal = dayOfMonth

            val date = Date.from(calender.toInstant())
            listener.setSpendingDate(date)

        }, yearCal, monthCal, dayCal).show()
    }
}



@BindingAdapter(value = ["app:image"])
fun setImage(view: ShapeableImageView, iconID: Int?) {
    iconID?.let { view.setImageResource(it) }
}

@BindingAdapter(value = ["checkAndInsert"])
fun checkDataToInsert(view: AppCompatButton, checkAndInsert: () -> Boolean) {
    view.setOnClickListener {
        if (checkAndInsert()) {
            Toast.makeText(view.context, "Successfully entered", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(view.context, "All data must be entered", Toast.LENGTH_LONG).show()
        }
    }
}


@BindingAdapter(value = ["app:setText"])
fun setTextForEditText(view: AppCompatEditText, setText: Double?) {
    if (setText != null && setText.toString() != view.text.toString()) {
        view.setText(setText.toString())
    }
}

@InverseBindingAdapter(attribute = "app:setText", event = "app:textAttrChanged")
fun getValue(view: AppCompatEditText): Double =
    if(view.text.toString().toDoubleOrNull() != null) {
        view.text.toString().toDouble()
    } else {
        Toast.makeText(view.context, "It must be a number", Toast.LENGTH_LONG).show()
        0.0
    }

@BindingAdapter("app:textAttrChanged")
fun setListener(view: AppCompatEditText, listener: InverseBindingListener?) {
    view.setOnFocusChangeListener { _ , hasFocus ->
        if (hasFocus) {
            view.setText("")
        } else {
            listener?.onChange()
        }
    }
}

@SuppressLint("SimpleDateFormat")
@BindingAdapter(value = ["app:date"])
fun setDate(view: TextView, date: Date?) {
    date?.let { view.text = SimpleDateFormat("MMM dd, yyyy hh:mm a").format(date) }
}