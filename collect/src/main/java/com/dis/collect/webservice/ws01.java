package com.dis.collect.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ws01 {

	//private final static Logger logger = LoggerFactory.getLogger(ws01.class);
	static Logger wsLogger = LoggerFactory.getLogger("webservice") ;
	
	public static void main(String[] args) {
		wsLogger.info("info");
		wsLogger.warn("warn");
		wsLogger.error("err0e adf");
	}

}
