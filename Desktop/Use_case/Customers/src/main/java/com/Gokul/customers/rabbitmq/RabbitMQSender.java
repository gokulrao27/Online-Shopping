package com.Gokul.customers.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Gokul.customers.dto.CustomerDTO;


@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingkey}")
	private String routingkey;

	public void send(CustomerDTO save) {
		try {
			rabbitTemplate.convertAndSend(exchange, routingkey, save);
			System.out.println("Successfuly Sent - " + save.toString());
		}catch(Exception e) {
			System.out.println(e);
		}

	}
}
