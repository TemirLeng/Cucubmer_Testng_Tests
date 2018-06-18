package com.app.stepDefs.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class JDBCWithLog4j {

	public static final Logger log = LogManager.getLogger(JDBCWithLog4j.class);

	@Test
	public void getRecordsCount() {
		log.info("This is info");
	}
}
