package com.watermelon.spendingtracker.ui.calender

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.spendingtracker.databinding.FragmentCalenderBinding
import com.watermelon.spendingtracker.ui.base.BaseFragment
import com.watermelon.spendingtracker.ui.home.TemplateAdapter

class CalenderFragment : BaseFragment<FragmentCalenderBinding>() {

    override val viewModel: CalenderViewModel by activityViewModels()

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) ->
    FragmentCalenderBinding = FragmentCalenderBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.spending.observe(this) { spendingList ->
            spendingList?.let {
                binding.calenderRecycler.adapter = CalenderAdapter(it, viewModel)
            }
        }
    }
}