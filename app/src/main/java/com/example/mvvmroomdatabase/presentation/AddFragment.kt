package com.example.mvvmroomdatabase.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mvvmroomdatabase.R
import com.example.mvvmroomdatabase.domain.Employee
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_list.view.*

class AddFragment : Fragment() {
    lateinit var viewModel: EmployeeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        viewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)
        view.addbutton.setOnClickListener {
            insertEmployee()
        }
        return view
    }

    fun insertEmployee() {
        val name = editname.text.toString()
        val design = editdesign.text.toString()
        val salary = editsalary.text.toString()
        val employee = Employee(0, name, design, Integer.parseInt(salary))
        viewModel.getAllEmployee(employee)
        Toast.makeText(requireContext(), "Successful", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }
}