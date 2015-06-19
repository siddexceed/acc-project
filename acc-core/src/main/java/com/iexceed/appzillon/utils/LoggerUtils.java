package com.iexceed.appzillon.utils;

import java.io.File;

import org.apache.log4j.Logger;

public class LoggerUtils {
	public static Logger log = Logger
			.getLogger("com.iexceed.appzillon.account");
	private static boolean created = false;

	public static Logger getLogger() {
		if (!created) {
			System.out.println("Creating the log folder");
			String logFilePath = System.getProperty("user.home")
					+ System.getProperty("file.separator") + "logs"
					+ System.getProperty("file.separator");
			System.out.println("Log File Path" + logFilePath);
			File file = new File(logFilePath);
			file.mkdir();
			System.setProperty("log.home", logFilePath);
			System.out.println("Log Home::" + System.getProperty("log.home"));
			created = true;
		}
		return log;
	}
}
