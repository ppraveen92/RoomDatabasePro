package com.example.mvvmroomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_table")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var name:String,var designation:String,var salary:Long)