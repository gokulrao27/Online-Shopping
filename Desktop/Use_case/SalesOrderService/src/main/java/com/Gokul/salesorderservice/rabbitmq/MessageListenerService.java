package com.Gokul.salesorderservice.rabbitmq;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Gokul.salesorderservice.dto.CustomerDTO;
import com.Gokul.salesorderservice.service.CustomerSOS;

@Component
public class MessageListenerService implements RabbitListenerConfigurer {

	@Autowired
	CustomerSOS customersos;
//    private static final Logger logger = LoggerFactory.getLogger(MessageListenerService.class);
	ModelMapper modelMapper = new ModelMapper();

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }
    @RabbitListener(queues = "${rabbitmq.queue}")
	public void receivedMessage(CustomerDTO customerDTO) {
		System.out.println("User Details Received is.. " + customerDTO);
		CustomerDTO createdCustomer = customersos.save(customerDTO);
        System.out.println("CustomerCreated is.. " + createdCustomer);
    }
}
