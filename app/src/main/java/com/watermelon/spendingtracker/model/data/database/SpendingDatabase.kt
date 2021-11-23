package com.watermelon.spendingtracker.model.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.watermelon.spendingtracker.model.data.Converters
import com.watermelon.spendingtracker.model.data.domain.Category
import com.watermelon.spendingtracker.model.data.domain.Spending
import com.watermelon.spendingtracker.model.data.domain.SpendingType
import com.watermelon.spendingtracker.model.data.domain.User

@Database(
    entities = [User::class, Spending::class, SpendingType::class, Category::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class SpendingDatabase : RoomDatabase() {

    abstract val spendDao: SpendingDao
    abstract val userDao: UserDao
    abstract val categoryDao: CategoryDao
    abstract val spendingTypesDao: SpendingTypesDao

    companion object {
        private const val DB_NAME = "DB_SPENDING"

        @Volatile
        private var instance: SpendingDatabase? = null

        private fun buildDatabase(context: Context): SpendingDatabase {
            return Room.databaseBuilder(context, SpendingDatabase::class.java, DB_NAME).build()
        }

        fun getInstance(context: Context): SpendingDatabase {
            return instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }
        }

        val getInstance get() = instance
    }

}
