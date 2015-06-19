package com.iexceed.appzillon.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.iexceed.appzillon.accountservice.ServiceController;

public class AccountContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent arg0) {
		ServiceController.getInstance();
	}

}
