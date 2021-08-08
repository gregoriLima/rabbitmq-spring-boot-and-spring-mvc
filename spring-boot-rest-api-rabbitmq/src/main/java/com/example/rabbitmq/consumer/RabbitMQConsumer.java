package com.example.rabbitmq.consumer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.model.PersonModel;

@Service
public class RabbitMQConsumer {

	// @RabbitListener(queues = "Mobile")
	// public void getMessage(/*byte[] message*/ PersonModel p) {
	// System.out.println(p.getName());
	// }
	
	
	// consumer for Header-Exchange 
	@RabbitListener(queues = "Mobile")
	public void getMessage( byte[] message ) throws IOException, ClassNotFoundException {

		ByteArrayInputStream bis = new ByteArrayInputStream(message);
		ObjectInput in = new ObjectInputStream(bis);
		PersonModel person = (PersonModel) in.readObject();
		in.close();
		bis.close();
		
		System.out.println(person.getName());
		
	}

}
