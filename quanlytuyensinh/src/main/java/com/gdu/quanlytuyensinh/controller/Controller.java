package com.gdu.quanlytuyensinh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.gdu.quanlytuyensinh.entity.Student;
import com.gdu.quanlytuyensinh.model.Model;
import com.gdu.quanlytuyensinh.view.Home;

public class Controller {

	Model model = new Model();
	
	public List<Student> fillterStudentName(String name)
	{
		List<Student> listStudent = new ArrayList<Student>();
		for(Student student: model.getAllStudent())
		{
			if(student.getHoTen().equals(name))
			{
				listStudent.add(student);
			}
		}
		return listStudent;
	}
}

