package com.rabbitmq.assets.queue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String message = "Message from RabbitMQ";
		
		// publishing in the queue (exchange, queue, properties, message)
		channel.basicPublish("", "Queue-1", null, message.getBytes());
		
		channel.close();
		connection.close();

	}

}
