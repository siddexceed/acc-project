package com.iexceed.appzillon.accountservice;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceController {

	private AbstractXmlApplicationContext springContext;
	private static ServiceController serviceController = null;

	private ServiceController() {
	}

	private AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext(
				"META-INF/spring/DOMAIN-Spring.xml");
	}

	public AbstractXmlApplicationContext getSpringContext() {

		if (springContext == null) {
			springContext = (AbstractXmlApplicationContext) createApplicationContext();

		}
		return springContext;

	}

	public static ServiceController getInstance() {

		if (serviceController == null) {
			serviceController = new ServiceController();
			serviceController.getSpringContext().start();
		}

		return serviceController;

	}

	public Object getService(String serviceName) {
		return getInstance().getSpringContext().getAutowireCapableBeanFactory()
				.getBean(serviceName);
	}
}
