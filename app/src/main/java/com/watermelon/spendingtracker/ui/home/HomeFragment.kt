package com.watermelon.spendingtracker.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.spendingtracker.databinding.FragmentHomeBinding
import com.watermelon.spendingtracker.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.spending.observe(this, { spendingList ->
            spendingList?.let {
                binding.expensesRecycler.adapter = TemplateAdapter(it, viewModel)
            }
        })
    }
}