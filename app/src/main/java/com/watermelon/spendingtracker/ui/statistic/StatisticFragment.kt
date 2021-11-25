package com.watermelon.spendingtracker.ui.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import com.watermelon.spendingtracker.R
import com.watermelon.spendingtracker.databinding.FragmentStatisticBinding
import com.watermelon.spendingtracker.model.data.database.entities.User
import com.watermelon.spendingtracker.ui.base.BaseFragment
import com.watermelon.spendingtracker.ui.home.HomeViewModel

class StatisticFragment : BaseFragment<FragmentStatisticBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentStatisticBinding
        get() = FragmentStatisticBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeChartShape()
        val adapter = ArrayAdapter(this, R.layout.drop_down_item, mutableListOf<User>())
        binding.selectedMeme.setAdapter(adapter)
    }

    private fun changeChartShape (){
    }
}