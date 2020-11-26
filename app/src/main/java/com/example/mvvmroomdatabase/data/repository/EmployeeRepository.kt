package com.example.mvvmroomdatabase.data.repository

import androidx.lifecycle.LiveData
import com.example.mvvmroomdatabase.data.EmployeeDao
import com.example.mvvmroomdatabase.domain.Employee

class EmployeeRepository(private val employeeDao: EmployeeDao) {

    val readAlltheData: LiveData<List<Employee>> = employeeDao.getAllEmployee()
    suspend fun addEmployee(employee: Employee) {
        employeeDao.addEmployee(employee)
    }

}