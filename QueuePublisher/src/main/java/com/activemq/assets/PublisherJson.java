package com.activemq.assets;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import netscape.javascript.JSObject;

public class PublisherJson {

	public static void main(String[] args) {
		
		ConnectionFactory factory = new ConnectionFactory();
		
		// try with resources, to automaticaly close connections
		try(	Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();	){
			
			JSONObject json = new JSONObject();
			json.put("from_date", "05-Aug-2021");
			json.put("to_date", "05-Sep-2021");	
			json.put("email", "testing@gmail.com");
			json.put("query", "select * from historic");
			
			// publishing in the queue (exchange, queue, properties, message)
			channel.basicPublish("", "Queue-1", null, json.toString().getBytes());
			
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
