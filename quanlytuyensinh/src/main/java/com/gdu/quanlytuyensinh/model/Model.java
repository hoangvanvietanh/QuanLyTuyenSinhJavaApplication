package com.gdu.quanlytuyensinh.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.gdu.quanlytuyensinh.config.ConnectMongoDB;
import com.gdu.quanlytuyensinh.entity.Student;
import com.google.gson.Gson;
import com.mongodb.client.FindIterable;

public class Model {

	ConnectMongoDB mongoDB = new ConnectMongoDB();	
	Gson g = new Gson();
	FindIterable<Document> findIterable;
	
	
	public List<Student> getAllStudent()
	{
		findIterable = mongoDB.collectionStudent().find(new Document());
		List<Student> studentList = new ArrayList<Student>();
		for(Document doc: findIterable)
		{
			Student s = g.fromJson(doc.toJson().toString(), Student.class);
			studentList.add(s);
		}		
		return studentList;
	}
}
