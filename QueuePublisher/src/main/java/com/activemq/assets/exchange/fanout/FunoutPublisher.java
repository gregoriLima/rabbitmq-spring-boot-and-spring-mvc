package com.activemq.assets.exchange.fanout;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class FunoutPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();

		// try with resources, to automaticaly close connections
		try (	Connection connection = factory.newConnection(); 
				Channel channel = connection.createChannel();) {

			JSONObject json = new JSONObject();
			json.put("message", "message for all subscribers");

			channel.basicPublish("Funout-Exchange", "", null, json.toString().getBytes());

		}
	}

}
