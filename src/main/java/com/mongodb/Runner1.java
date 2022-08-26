package com.mongodb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Runner1 {

	public static void main(String[] args) throws IOException{
		List<User> users = new ArrayList<User>();
		MongoClient client = new MongoClient("localhost",27017);
		System.out.println("Connected successfully");
		MongoDatabase db = client.getDatabase("user");
		System.out.println("Got database");
		MongoCollection<Document> collection = db.getCollection("users");
		System.out.println("Got collection");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter first name : ");
		String firstName = String.valueOf(reader.readLine());
		
		System.out.println("Enter age : ");
		int age = Integer.valueOf(reader.readLine());
		
		System.out.println("Enter city ");
		String city = String.valueOf(reader.readLine());
		
		//inserting a record
		Document d = new Document();
		d.append("name", firstName);
		d.append("age", age);
		d.append("city", city);
		collection.insertOne(d);
		System.out.println("Record inserted ! ");
		User u = new User(firstName,age,city);
		users.add(u);
		
		//updating record
		System.out.println("------------------------------");
		System.out.println("Enter the name for which the record is to be updated");
		String name=String.valueOf(reader.readLine());
		System.out.println("Enter the new age:");
		int newage = Integer.valueOf(reader.readLine());
		BasicDBObject query =new BasicDBObject();
		
		
		//displaying all the results
		FindIterable<Document> list = collection.find();
		Iterator<Document> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("End");
		
		//comment
	}

}
