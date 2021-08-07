package com.example.rabbitmq.controller;

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

	// testing for publish messages in route, direct, funout and topic exchange
	/*
	 * @GetMapping ("/test/{name}") public String testApi(@PathVariable("name")
	 * String name) {
	 * 
	 * PersonModel person = new PersonModel(1L, name);
	 * 
	 * // (queue name, serializable object) rabbitTemplate.convertAndSend("Mobile",
	 * person); // to route rabbitTemplate.convertAndSend("Direct-Exchange", "tv",
	 * person); // to direct exchange
	 * rabbitTemplate.convertAndSend("Funout-Exchange", "", person); // to funout
	 * exchange rabbitTemplate.convertAndSend("Topic-Exchange", "tv.mobile.ac",
	 * person); // to topic exchange
	 * 
	 * return "Success"; }
	 */

	// testing for publish messages in Headers-Exchange
	@GetMapping("/test/{name}")
	public String testApi(@PathVariable("name") String name) {
		
		PersonModel person = new PersonModel(1L, name);
		
		return "Success";
	}
}






