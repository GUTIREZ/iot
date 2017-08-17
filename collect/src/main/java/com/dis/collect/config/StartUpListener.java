package com.dis.collect.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dis.collect.sample.RabbitMQSendDemo;

@Component
public class StartUpListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	StartUpConfig startConfig;
	
	@Autowired
	RabbitMQSendDemo senderDemo;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//System.out.println("onApplicationEvent ############################################");
		//startConfig.name();
		
		//senderDemo.run();
	}
}
