package com.activemq.assets.exchange.direct;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();

		// try with resources, to automaticaly close connections
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel();) {

			JSONObject json = new JSONObject();
			json.put("mobile", "version2");

			channel.basicPublish("Direct-Exchange", "mobile", null, json.toString().getBytes());

			json.clear();
			json.put("tv", "58");

			channel.basicPublish("Direct-Exchange", "tv", null, json.toString().getBytes());

			json.clear();
			json.put("ac", "song3");

			channel.basicPublish("Direct-Exchange", "ac", null, json.toString().getBytes());

		}

	}

}
