package com.rabbitmq.assets.exchange.consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class ConsumerTV {

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
				ConnectionFactory factory = new ConnectionFactory();
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();
				
				DeliverCallback deliverCallback = (consumerTag, delivery) -> {
					String message = new String(delivery.getBody());
					System.out.println("TV - Message received: " + message);
				};
							// (queue, auto-ackologe?, deliveryCallback, cancelCallback)
				channel.basicConsume("TV", true, deliverCallback, consumerTag -> {});
				
				// can not close channel in consumer, because it is every time listem for messages
	}

}
