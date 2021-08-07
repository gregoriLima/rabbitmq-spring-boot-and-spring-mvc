package com.example.rabbitmq.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.model.PersonModel;

@RestController
@RequestMapping("/api/v1")
public class TestController {

	@Autowired
	RabbitTemplate rabbitTemplate; // usado para publicar as mensagens

	// testing for publish messages in route, direct, fanout and topic exchange
	/*
	 * @GetMapping ("/test/{name}") public String testApi(@PathVariable("name")
	 * String name) {
	 * 
	 * PersonModel person = new PersonModel(1L, name);
	 * 
	 * // (queue name, serializable object) rabbitTemplate.convertAndSend("Mobile",
	 * person); // to route rabbitTemplate.convertAndSend("Direct-Exchange", "tv",
	 * person); // to direct exchange
	 * rabbitTemplate.convertAndSend("Fanout-Exchange", "", person); // to funout
	 * exchange rabbitTemplate.convertAndSend("Topic-Exchange", "tv.mobile.ac",
	 * person); // to topic exchange
	 * 
	 * return "Success"; }
	 */

	// testing for publish messages in Headers-Exchange
	@GetMapping("/test/{name}")
	public String testApi(@PathVariable("name") String name) throws IOException {
		
		PersonModel person = new PersonModel(1L, name);
		
		// converting person object to bytes
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);
		out.writeObject(person);
		out.flush();
		out.close();
		
		byte[] byteMessage = bos.toByteArray();
		bos.close();
		
		Message message = MessageBuilder
				.withBody(byteMessage)
				.setHeader("item1", "mobile")
				.setHeader("item2", "television")
				.build();
		
		rabbitTemplate.send("Headers-Exchange", "", message );
		
		return "Success";
	}
}






