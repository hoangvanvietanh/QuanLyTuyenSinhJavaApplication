package com.gdu.quanlytuyensinh.main;

import com.gdu.quanlytuyensinh.config.ConnectMongoDB;
import com.gdu.quanlytuyensinh.controller.Controller;
import com.gdu.quanlytuyensinh.view.AddStudent;
import com.gdu.quanlytuyensinh.view.Home;

public class Main {

	public static void main(String[] args) {
		//ConnectMongoDB c = new ConnectMongoDB();
		//c.test();
		//Controller controler = new Controller();
		Home.createHomeView();
		//controler.createTableShowAllStudent();
		//AddStudent ad = new AddStudent();
		//ad.createFormAddStudent();
	}

}
