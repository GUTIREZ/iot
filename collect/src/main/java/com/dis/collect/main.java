package com.dis.collect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class main {

	private final static Logger logger = LoggerFactory.getLogger(main.class);

	public static void main(String[] args) {

		System.out.println(0.05 + 0.01);
		System.out.println(1.0 - 0.42);
		System.out.println(4.015 * 100);
		System.out.println(123.3 / 100);

		logger.info("info xx");
		logger.error("error xx");
		logger.warn("warn xx");
	}
}
