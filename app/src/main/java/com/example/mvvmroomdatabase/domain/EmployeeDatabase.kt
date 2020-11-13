package com.example.mvvmroomdatabase.domain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmroomdatabase.data.EmployeeDao

@Database(entities = [Employee::class],version = 1,exportSchema = false)
abstract class EmployeeDatabase : RoomDatabase(){

    abstract fun employeeDao(): EmployeeDao

    companion object{
        @Volatile
        private var INSTANCE : EmployeeDatabase?=null

        fun getDatabase(context: Context): EmployeeDatabase {
            val tempInstance = INSTANCE
            if(tempInstance!=null)
            {
                return tempInstance
            }

            synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EmployeeDatabase::class.java,
                    "employee_database"
                ).build()
                INSTANCE =instance
                return instance
            }
        }
    }

}