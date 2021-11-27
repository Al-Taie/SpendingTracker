package com.watermelon.spendingtracker.ui.statistic

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.watermelon.spendingtracker.databinding.FragmentStatisticBinding
import com.watermelon.spendingtracker.ui.base.BaseFragment

class StatisticFragment : BaseFragment<FragmentStatisticBinding>() {
    override val viewModel: StatisticViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentStatisticBinding
        get() = FragmentStatisticBinding::inflate

    private val pieChart by lazy { binding.pieChartView }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeChartShape()
        setupPieChart()

        viewModel.userCategories.observe(this, { viewModel.getSumOfSpendingByCategory() })

        viewModel.chartData.observe(this, { loadPieChartData(it) })

        viewModel.spending.observe(this, {binding.totalValue.text = (it?:0.0).toString()})
    }

    private fun changeChartShape() {}


    private fun setupPieChart() {
        pieChart.apply {
            isDrawHoleEnabled = true
            setUsePercentValues(true)
            setEntryLabelTextSize(12f)
            setEntryLabelColor(Color.BLACK)
            centerText = "Spending"
            setCenterTextSize(17f)
            description.isEnabled = false

            legend.apply {
                verticalAlignment = Legend.LegendVerticalAlignment.TOP
                horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
                orientation = Legend.LegendOrientation.VERTICAL
                setDrawInside(false)
                isEnabled = true
            }
        }
    }

    private fun loadPieChartData(dataList: List<Pair<String, Float>>?) {
        val entries: ArrayList<PieEntry> = ArrayList()

        dataList?.forEach { entries.add(PieEntry(it.second, it.first)) }

        val colors: ArrayList<Int> = ArrayList()
        ColorTemplate.MATERIAL_COLORS.forEach(colors::add)
        ColorTemplate.VORDIPLOM_COLORS.forEach(colors::add)

        val dataSet = PieDataSet(entries, "Expense Category").apply { this.colors = colors }
        val data = PieData(dataSet).apply {
            setDrawValues(true)
            setValueTextSize(12f)
            setValueTextColor(Color.BLACK)
        }

        pieChart.apply {
            this.data = data
            invalidate()
            animateY(1400, Easing.EasingOption.EaseInOutQuad)
        }
    }
}