package com.watermelon.spendingtracker.ui.base
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.watermelon.spendingtracker.model.data.database.SpendingDatabase


abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity() {
    abstract val theme: Int
    abstract val viewID: Int
    private lateinit var _binding: VDB
    protected val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SpendingDatabase.getInstance(applicationContext)
        _binding = DataBindingUtil.setContentView(this, viewID)
    }
}