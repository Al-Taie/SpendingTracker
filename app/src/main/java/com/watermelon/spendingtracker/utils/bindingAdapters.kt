package com.watermelon.spendingtracker.utils

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.watermelon.spendingtracker.R
import com.watermelon.spendingtracker.model.data.State
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.model.data.database.relations.UserCategoriesCrossRef
import com.watermelon.spendingtracker.model.data.database.relations.UserWithCategoriesAndSpending
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
@BindingAdapter(value = ["app:selectedItem", "app:listener", "app:stream"])
fun onClickSelectedItem(view: View, selectedItem: ShapeableImageView?,
                        listener: CategoriesInteractionListener, itemId: Long?) {
    view.setOnClickListener {
        selectedItem?.setBackgroundColor(R.color.base_color)
        selectedItem?.setColorFilter(ContextCompat.getColor(view.context, R.color.white))
        listener.onClickCategories(itemId)
    }
}

@BindingAdapter(value = ["app:listenerDate"])
fun setDateCalender(view: ImageView, listener: TemplateInteractionListener) {

    val cal: Calendar = Calendar.getInstance()
    var dayCal = cal.get(Calendar.DAY_OF_WEEK)
    var monthCal = cal.get(Calendar.MONTH)
    var yearCal = cal.get(Calendar.YEAR)

    view.setOnClickListener {
        DatePickerDialog(view.context, { _, year, monthOfYear, dayOfMonth ->
            cal.set(year, monthOfYear, dayOfMonth)
            yearCal = year
            monthCal = monthOfYear
            dayCal = dayOfMonth

            listener.setSpendingDate(DateFormat.getDateInstance(DateFormat.MEDIUM).format(cal.time))

        }, yearCal, monthCal, dayCal).show()
    }

}


@BindingAdapter(value = ["app:users"])
fun setUsers(view: MaterialAutoCompleteTextView, data: List<User>?) {
    Log.v("TESTING", data.toString())
    data?.map { it.name }?.let { usersArray ->
        val adapter = ArrayAdapter(view.context, R.layout.drop_down_item, usersArray)
        view.setAdapter(adapter)
    }
}

private fun setSpinnerListener(spinner: Spinner, listener: InverseBindingListener) {
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) =
            listener.onChange()

        override fun onNothingSelected(adapterView: AdapterView<*>) = listener.onChange()
    }
}

private fun setCurrentSelection(spinner: Spinner, selectedItem: User?): Boolean {
    if (selectedItem == null) {
        return false
    }

    for (index in 0 until spinner.adapter.count) {
        val currentItem = spinner.getItemAtPosition(index) as User
        if (currentItem.name == selectedItem.name) {
            spinner.setSelection(index)
            return true
        }
    }
    return false
}

@BindingAdapter(value = ["app:setSrc"])
fun setSrcImg(view: ShapeableImageView, item: IconsForCategories?){
    item?.let {
        view.setImageResource(item.icon)
    }
}



