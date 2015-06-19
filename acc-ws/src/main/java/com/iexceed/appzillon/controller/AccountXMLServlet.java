package com.iexceed.appzillon.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.iexceed.appzillon.accountservice.AccountService;
import com.iexceed.appzillon.accountservice.ServiceController;
import com.iexceed.appzillon.jaxb.AccountCreationReq;
import com.iexceed.appzillon.jaxb.AccountCreationRes;
import com.iexceed.appzillon.jaxb.AccountMasterQueryRes;
import com.iexceed.appzillon.utils.JAXBUtils;
import com.iexceed.appzillon.utils.JSONUtils;
import com.iexceed.appzillon.utils.JsonToXMLConverter;
import com.iexceed.appzillon.utils.LoggerUtils;
import com.iexceed.appzillon.utils.MapUtils;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountXMLServlet")
public class AccountXMLServlet extends HttpServlet {
	public static Logger log = LoggerUtils.getLogger();
	private static final long serialVersionUID = 1L;

	public AccountXMLServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		log.debug("Entered Servlet Service");
		String accountNo = request.getParameter("accountNo");
		Map<String, String> accountResMap = null;
		AccountService accountService = (AccountService) ServiceController
				.getInstance().getService("AccountService");
		log.debug("Account Service Injected::" + accountService);
		AccountMasterQueryRes accountMasterQueryRes = accountService
				.queryAccount(accountNo);
		try {
			accountResMap = MapUtils.convertObjectToMap(accountMasterQueryRes);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.write(JsonToXMLConverter.jsonToXml(JSONUtils
				.getJsonStringFromMap(accountResMap)));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("Entered Servlet");
		log.info("Calling Account Save");
		BufferedReader bufferedReader = null;
		StringBuilder stringBuilder = new StringBuilder();
		Map<String, String> accountResMap = null;
		InputStream inputStream = request.getInputStream();
		if (inputStream != null) {
			bufferedReader = new BufferedReader(new InputStreamReader(
					inputStream));
			char[] charBuffer = new char[128];
			int bytesRead = -1;
			while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
				stringBuilder.append(charBuffer, 0, bytesRead);
			}
		} else {
			stringBuilder.append("");
		}
		AccountCreationReq accountCreationReq = (AccountCreationReq) JAXBUtils
				.getUnMarshalled(stringBuilder.toString(),
						"com.iexceed.appzillon.jaxb.AccountCreationReq");
		AccountService accountService = (AccountService) ServiceController
				.getInstance().getService("AccountService");
		AccountCreationRes accountCreationRes = accountService
				.saveAccount(accountCreationReq);
		try {
			accountResMap = MapUtils.convertObjectToMap(accountCreationRes);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.write(JsonToXMLConverter.jsonToXml(JSONUtils
				.getJsonStringFromMap(accountResMap)));
	}

}
