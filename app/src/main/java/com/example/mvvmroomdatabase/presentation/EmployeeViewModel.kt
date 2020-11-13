package com.example.mvvmroomdatabase.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmroomdatabase.domain.Employee
import com.example.mvvmroomdatabase.domain.EmployeeDatabase
import com.example.mvvmroomdatabase.domain.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(application: Application) :AndroidViewModel(application) {
    private val getAllEmployee:LiveData<List<Employee>>
    private val repository : EmployeeRepository

    init {
        val employeeDao = EmployeeDatabase.getDatabase(application).employeeDao()
        repository = EmployeeRepository(employeeDao)
        getAllEmployee =repository.readAlltheData
    }

    fun addEmployee(employee: Employee){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.addEmployee(employee)
        }
    }

}