package com.watermelon.spendingtracker.ui.addTemplate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.spendingtracker.databinding.FragmentAddTamplateBinding
import com.watermelon.spendingtracker.ui.base.BaseFragment

class AddTemplateFragment : BaseFragment<FragmentAddTamplateBinding>() {

    override val viewModel: AddTemplateViewModel by activityViewModels()

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) ->
                         FragmentAddTamplateBinding = FragmentAddTamplateBinding::inflate

}