package com.app.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	public static final Logger log=LogManager.getLogger();

	public static void main(String[] args) {
		
		log.info("This is info log step");
		log.warn("This is a warning");
		log.debug("This is a debug");
		log.error("This is error");
//		log.fatal("This is fatal");

	}
}
