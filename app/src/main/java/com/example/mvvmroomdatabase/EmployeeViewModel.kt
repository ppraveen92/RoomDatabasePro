package com.example.mvvmroomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
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