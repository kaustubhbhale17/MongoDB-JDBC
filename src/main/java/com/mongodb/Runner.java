package com.mongodb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Runner {
	
	
	public static void main(String[] args) {
		
		List<User> userList = new ArrayList<User>();
		MongoClient mongo = new MongoClient("localhost",27017);
		System.out.println("Connected to mongoDB");
		
		MongoDatabase db =mongo.getDatabase("user");
		System.out.println("DB connected successfully");
		
		MongoCollection<Document> collection = db.getCollection("users");
		System.out.println("Collection created");
		
//		Document doc1 = new Document();
//		doc1.append("name","Ajit");
//		doc1.append("age",21);
//		doc1.append("city","Mumbai");
//		collection.insertOne(doc1);
//		
//		Document d2 = new Document();
//		d2.append("name","Soham");
//		d2.append("age",27);
//		d2.append("city","Pune");
//		collection.insertOne(d2);
//		
//		System.out.println("Insertion done");

		//getting a specific document
//		BasicDBObject searchQuery = new BasicDBObject();
//		searchQuery.put("name", "Soham");
//
//		MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
//		while(cursor.hasNext()) {
//			System.out.println(cursor.next());
//		}
		
		collection.updateOne(Filters.eq("name", "SimplifyingTech"),Updates.set("Genre", "Coding"));
		
		
		//displaying the data
//		FindIterable<Document> list =collection.find();
//		
//		Iterator<Document> it = list.iterator();
//		while(it.hasNext()) {
//			Document d = it.next();
//			String id = String.valueOf(d.get("_id"));
//			String name=String.valueOf(d.get("name"));
//			int age = Integer.valueOf(String.valueOf(d.get("age")));
//			String city = (String) d.get("city");
//			User user = new User(id,name,age,city);
//			userList.add(user);
//			//System.out.println(id+"\n"+name+"\n"+age+"\n"+city);
//			//System.out.println(d);
//		}
//		
//		
//		//displaying the list of all users
//		for(User u : userList) {
//			System.out.println("ID   : "+u.getId());
//			System.out.println("First Name : "+u.getFname());
//			System.out.println("Age: "+u.getAge());
//			System.out.println("City: "+u.getCity());
//			System.out.println("_________________________________");
//		}
		mongo.close();
		
	}

}
