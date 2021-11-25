package com.watermelon.spendingtracker

import android.os.Bundle
import androidx.navigation.findNavController
import com.watermelon.spendingtracker.databinding.ActivityMainBinding
import com.watermelon.spendingtracker.model.data.database.SpendingDatabase
import com.watermelon.spendingtracker.ui.base.BaseActivity
import com.watermelon.spendingtracker.utils.onNavDestinationSelected

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_SpendingTracker
    override val viewID = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SpendingDatabase.getInstance(applicationContext)
    }

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