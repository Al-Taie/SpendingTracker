package com.watermelon.spendingtracker.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.watermelon.spendingtracker.databinding.FragmentHomeBinding
import com.watermelon.spendingtracker.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    private val pieChart by lazy { binding.pieChartView }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPieChart()

        viewModel.userCategories.observe(this, { viewModel.getSumOfSpendingByCategory() })

        viewModel.chartData.observe(this, { loadPieChartData(it) })


        viewModel.spending.observe(this) { spendingList ->
            spendingList?.let {
                binding.expensesRecycler.adapter = TemplateAdapter(it, viewModel)
            }
        }
    }


    private fun setupPieChart() {
        pieChart.apply {
            isDrawHoleEnabled = true
            setUsePercentValues(true)
            setEntryLabelTextSize(0f)
            setEntryLabelColor(Color.WHITE)
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

        listOf("#75629A", "#A998CA", "#25095B", "#BD7AE3", "#7F67AD").map { ColorTemplate.rgb(it) }
            .forEach(colors::add)

        val dataSet = PieDataSet(entries, "Category").apply { this.colors = colors }
        dataSet.valueTextSize=10f
        val data = PieData(dataSet).apply {
            setDrawValues(true)
            setValueTextSize(12f)
            setValueTextColor(Color.WHITE)
        }

        pieChart.apply {
            this.data = data
            invalidate()
            animateY(1400, Easing.EasingOption.EaseInOutQuad)
        }
    }
}