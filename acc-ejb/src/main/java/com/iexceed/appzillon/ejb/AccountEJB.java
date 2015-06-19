package com.iexceed.appzillon.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.iexceed.appzillon.accountservice.AccountService;
import com.iexceed.appzillon.accountservice.ServiceController;
import com.iexceed.appzillon.client.AccountEJBLocal;
import com.iexceed.appzillon.client.AccountEJBRemote;
import com.iexceed.appzillon.jaxb.AccountCreationReq;
import com.iexceed.appzillon.jaxb.AccountCreationRes;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteReq;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteRes;
import com.iexceed.appzillon.jaxb.AccountMasterQueryReq;
import com.iexceed.appzillon.jaxb.AccountMasterQueryRes;
import com.iexceed.appzillon.utils.LoggerUtils;

/**
 * Session Bean implementation class AccountEJB
 */
@Stateless
@LocalBean
public class AccountEJB implements AccountEJBRemote, AccountEJBLocal {

	public static Logger log = LoggerUtils.getLogger();

	public AccountEJB() {
		// TODO Auto-generated constructor stub
	}

	public AccountCreationRes saveAccount(AccountCreationReq accCreatereq) {
		log.info("Entered EJB");
		log.info("Calling Account Save");
		AccountService accountService = (AccountService) ServiceController
				.getInstance().getService("AccountService");
		log.debug("Account Service Injected::" + accountService);
		return accountService.saveAccount(accCreatereq);

	}

	public AccountMasterDeleteRes deleteAccount(
			AccountMasterDeleteReq accounMasterDelreq) {
		log.info("Entered EJB");
		log.info("Calling Account delete");
		AccountService accountService = (AccountService) ServiceController
				.getInstance().getService("AccountService");
		log.debug("Account Service Injected::" + accountService);
		return accountService.deleteAccount(accounMasterDelreq);
	}

	public AccountMasterQueryRes queryAccount_1(
			AccountMasterQueryReq accounMasterQyrreq) {
		log.info("Entered EJB::"+accounMasterQyrreq.getAccountNum());
		log.info("Calling Account query");
		AccountService accountService = (AccountService) ServiceController
				.getInstance().getService("AccountService");
		log.debug("Account Service Injected::" + accountService);
		return accountService.queryAccount(accounMasterQyrreq);
	}

	public AccountMasterQueryRes queryAccount_2(String accountNo) {
		log.info("Entered EJB");
		log.info("Calling Account query");
		AccountService accountService = (AccountService) ServiceController
				.getInstance().getService("AccountService");
		log.debug("Account Service Injected::" + accountService);
		return accountService.queryAccount(accountNo);
	}

}
