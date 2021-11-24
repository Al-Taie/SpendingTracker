package com.watermelon.spendingtracker.ui.addaccount

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.spendingtracker.databinding.FragmentAddAccountBinding
import com.watermelon.spendingtracker.ui.base.BaseFragment

class AddAccountFragment : BaseFragment<FragmentAddAccountBinding>() {
    override val viewModel: AddAccountViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentAddAccountBinding
        get() = FragmentAddAccountBinding::inflate

}