package com.samco.model;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongodbAtlas {

	public static void main(String[] args) {
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://Nitheesh:Atlas123@cluster0.q7oseyn.mongodb.net/?retryWrites=true&w=majorityconnectTimeoutMS=30000&socketTimeoutMS=30000&keepAliveMS=100");

		

		try (MongoClient mongoClient = new MongoClient(uri)) {
			MongoDatabase database = mongoClient.getDatabase("sample_weatherdata");
			MongoCollection<Document> collection = database.getCollection("data");
			Document query = new Document("_id", new ObjectId("5553a998e4b02cf7151190b9"));
			Document result = collection.find(query).iterator().next();

			System.out.println(collection.count());
		}
	}
}