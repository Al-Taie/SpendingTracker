package com.watermelon.spendingtracker

import com.watermelon.spendingtracker.databinding.ActivityMainBinding
import com.watermelon.spendingtracker.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_SpendingTracker
    override val viewID = R.layout.activity_main
}