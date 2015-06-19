package com.iexceed.appzillon.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import com.iexceed.appzillon.accountservice.AccountService;
import com.iexceed.appzillon.accountservice.ServiceController;
import com.iexceed.appzillon.accountservice.TransactionService;
import com.iexceed.appzillon.jaxb.AccountCreationReq;
import com.iexceed.appzillon.jaxb.AccountCreationRes;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteReq;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteRes;
import com.iexceed.appzillon.jaxb.AccountMasterQueryReq;
import com.iexceed.appzillon.jaxb.AccountMasterQueryRes;
import com.iexceed.appzillon.jaxb.TransactionMasterQueryReq;
import com.iexceed.appzillon.jaxb.TransactionMasterQueryRes;
import com.iexceed.appzillon.utils.LoggerUtils;

@WebService(name = "AccounService11", serviceName = "AccountService11", targetNamespace = "http://www.iexceed.com")
@BindingType(value = SOAPBinding.SOAP11HTTP_BINDING)
public class AccountService11Impl {
	public static Logger log = LoggerUtils.getLogger();

	@WebMethod
	@WebResult(name = "AccountCreationRes")
	public AccountCreationRes accountCreation(
			@WebParam(name = "AccountCreationReq") AccountCreationReq accCreatereq) {
		log.debug("Entered Soap Service");
		AccountService accountService = (AccountService) ServiceController
				.getInstance().getService("AccountService");
		log.debug("Account Service Injected::" + accountService);
		return accountService.saveAccount(accCreatereq);
	}

	@WebMethod
	@WebResult(name = "AccountMasterQueryRes")
	public AccountMasterQueryRes accountQuery(
			@WebParam(name = "AccountMasterQueryReq") AccountMasterQueryReq accQueryReq) {
		log.debug("Entered Soap Service");
		AccountService accountService = (AccountService) ServiceController
				.getInstance().getService("AccountService");
		log.debug("Account Service Injected::" + accountService);
		return accountService.queryAccount(accQueryReq);
	}

	@WebMethod
	@WebResult(name = "AccountMasterDeleteRes")
	public AccountMasterDeleteRes accountDelete(
			@WebParam(name = "AccountMasterDeleteReq") AccountMasterDeleteReq accDeleteReq) {
		log.debug("Entered Soap Service");
		AccountService accountService = (AccountService) ServiceController
				.getInstance().getService("AccountService");
		log.debug("Account Service Injected::" + accountService);
		return accountService.deleteAccount(accDeleteReq);
	}
	

}
