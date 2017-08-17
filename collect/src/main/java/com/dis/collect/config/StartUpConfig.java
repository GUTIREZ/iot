package com.dis.collect.config;

import org.springframework.stereotype.Component;

@Component
public class StartUpConfig {
	// rabbitMQ  
	public void name() {
		System.out.println("启动执行！");
	}
	
	public void nettyConnection() {
		System.out.println("连接rabbitMQ！");
	}
}
