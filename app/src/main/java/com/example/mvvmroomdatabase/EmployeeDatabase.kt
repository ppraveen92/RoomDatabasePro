package com.example.mvvmroomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Employee::class],version = 1,exportSchema = false)
abstract class EmployeeDatabase : RoomDatabase(){
    

}