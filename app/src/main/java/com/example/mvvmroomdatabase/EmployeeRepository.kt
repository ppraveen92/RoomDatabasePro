package com.example.mvvmroomdatabase

import androidx.lifecycle.LiveData

class EmployeeRepository(private val employeeDao: EmployeeDao) {


    val readAlltheData:LiveData<List<Employee>> = employeeDao.getAllEmployee()
    suspend fun addEmployee(employee:Employee){

        employeeDao.addEmployee(employee)
    }

}