package com.watermelon.spendingtracker

import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.watermelon.spendingtracker.databinding.ActivityMainBinding
import com.watermelon.spendingtracker.ui.base.BaseActivity
import com.watermelon.spendingtracker.utils.onNavDestinationSelected

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_SpendingTracker
    override val viewID = R.layout.activity_main

        override fun onResume() {
            super.onResume()
            initNavBar()


    }

    private fun initNavBar() {
        val navController = findNavController(R.id.fragment_container_view)

        binding.bubbleTabBar.apply {
            addBubbleListener { id ->
                onNavDestinationSelected(id, navController)
            }

            navController.addOnDestinationChangedListener { _, destination, _ ->
                this.setSelectedWithId(destination.id, false)
            }
        }
    }
}