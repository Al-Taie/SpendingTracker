package com.watermelon.spendingtracker.utils

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.watermelon.spendingtracker.R
import com.watermelon.spendingtracker.model.data.State
import com.watermelon.spendingtracker.ui.addTemplate.CategoriesInteractionListener
import com.watermelon.spendingtracker.ui.addTemplate.TemplateInteractionListener
import com.watermelon.spendingtracker.ui.base.BaseAdapter
import java.text.DateFormat
import java.util.*


@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>?) {
    view.isVisible = (state is State.Loading)
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>?) {
    view.isVisible = (state is State.Error)
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>?) {
    view.isVisible = (state is State.Success)
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView?, items: List<T>?) {
    (view?.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter(value = ["app:stream", "app:listener"], requireAll = false)
fun streamObserve(view: View, itemId: Int?, listener: TemplateInteractionListener?) =
    view.setOnClickListener {
        listener?.setSpendingType(itemId)
    }


@SuppressLint("ResourceAsColor")
@BindingAdapter(value = ["app:selectedItem", "app:listener" ,  "app:stream"])
fun onClickSelectedItem(view: View, selectedItem: ShapeableImageView?
                        , listener: CategoriesInteractionListener , itemId: Long? ){
   view.setOnClickListener {
       selectedItem?.setBackgroundColor(R.color.base_color)
       selectedItem?.setColorFilter(ContextCompat.getColor(view.context , R.color.white))
       listener.onClickCategories(itemId)
   }
}

@BindingAdapter(value = ["listenerDate"])
fun setDateCalender(view: ImageView, listener: TemplateInteractionListener) {

    val cal: Calendar = Calendar.getInstance()
    var dayCal =  cal.get(Calendar.DAY_OF_WEEK)
    var monthCal = cal.get(Calendar.MONTH)
    var yearCal = cal.get(Calendar.YEAR)

    view.setOnClickListener { v ->

        DatePickerDialog(view.context, { view, year, monthOfYear, dayOfMonth ->
            cal.set(year, monthOfYear, dayOfMonth)
            yearCal = year
            monthCal = monthOfYear
            dayCal = dayOfMonth

            listener.setSpendingDate(DateFormat.getDateInstance(DateFormat.MEDIUM).format(cal.time))

        },yearCal,monthCal ,dayCal).show()
    }
}