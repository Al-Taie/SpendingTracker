package com.watermelon.spendingtracker.ui.addaccount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.spendingtracker.databinding.FragmentAddAccountBinding
import com.watermelon.spendingtracker.ui.base.BaseFragment

class AddAccountFragment : BaseFragment<FragmentAddAccountBinding>() {

    override val viewModel: AddAccountViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) ->
    FragmentAddAccountBinding = FragmentAddAccountBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addAccount.setOnClickListener{
            viewModel.addUserAccount()
        }
    }
}