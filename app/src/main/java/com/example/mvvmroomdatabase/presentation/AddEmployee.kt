package com.example.mvvmroomdatabase.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmroomdatabase.R

class AddEmployee : AppCompatActivity() {

    lateinit var  viewModel: EmployeeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)



    }


}