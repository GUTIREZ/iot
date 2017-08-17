package com.dis.collect.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dis.collect.config.rabbitMQ.RabbitMQSender;

@Component
public class RabbitMQSendDemo  implements Runnable{
	@Autowired
	RabbitMQSender sender;
	int i = 0;
	public void run() {
		while(i<10) {
			sender.sendMsg("发送："+i+"次！");
			//i++;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
