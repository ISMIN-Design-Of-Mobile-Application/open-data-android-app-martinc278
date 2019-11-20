package com.ismin.opendataapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Starbucks::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getStarbuckskDao(): StarbucksDAO

    companion object {
        private var INSTANCE: AppDataBase? = null

        fun getAppDatabase(context: Context): AppDataBase {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class) {
                    INSTANCE = Room
                        .databaseBuilder(context.applicationContext,
                            AppDataBase::class.java,
                            "db")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE as AppDataBase
        }
    }

}