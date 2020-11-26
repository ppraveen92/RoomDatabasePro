package com.example.mvvmroomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmroomdatabase.domain.Employee

@Dao
interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEmployee(employee: Employee)

    @Query("SELECT * FROM employee_table ORDER BY id ASC")
    fun getAllEmployee(): LiveData<List<Employee>>
}