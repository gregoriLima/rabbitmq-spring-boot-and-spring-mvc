package com.rabbitmq.assets.exchange.headers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class HeadersPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();

		// try with resources, to automaticaly close connections
		try (   Connection connection = factory.newConnection(); 
				Channel channel = connection.createChannel();) {

			JSONObject json = new JSONObject();
			json.put("message", "message to mobile and television");
			
			Map<String, Object> headersMap = new HashMap<>();
			headersMap.put("item1", "mobile");
			headersMap.put("item2", "television");
			
			BasicProperties bp = new BasicProperties();
			bp = bp.builder().headers(headersMap).build();
			
			channel.basicPublish("Headers-Exchange", "", bp, json.toString().getBytes());

		}

	}

}
