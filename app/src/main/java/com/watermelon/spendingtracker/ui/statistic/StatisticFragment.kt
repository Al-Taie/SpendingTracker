package com.watermelon.spendingtracker.ui.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.spendingtracker.databinding.FragmentStatisticBinding
import com.watermelon.spendingtracker.ui.base.BaseFragment

class StatisticFragment : BaseFragment<FragmentStatisticBinding>() {
    override val viewModel: StatisticViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentStatisticBinding
        get() = FragmentStatisticBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeChartShape()

        viewModel.spending.observe(this, {binding.totalValue.text = (it?:0.0).toString()})
    }

    private fun changeChartShape() {
    }
}