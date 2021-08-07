package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.model.PersonModel;

@Service
public class RabbitMQConsumer {

	// @RabbitListener(queues = "Mobile")
	// public void getMessage(/*byte[] message*/ PersonModel p) {
	// System.out.println(p.getName());
	// }

}
