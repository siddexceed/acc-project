package com.iexceed.appzillon.client;

import javax.ejb.Remote;

import com.iexceed.appzillon.jaxb.AccountCreationReq;
import com.iexceed.appzillon.jaxb.AccountCreationRes;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteReq;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteRes;
import com.iexceed.appzillon.jaxb.AccountMasterQueryReq;
import com.iexceed.appzillon.jaxb.AccountMasterQueryRes;

@Remote
public interface AccountEJBRemote {
	public AccountCreationRes saveAccount(AccountCreationReq accCreatereq);
	public AccountMasterDeleteRes deleteAccount(AccountMasterDeleteReq accounMasterDelreq);
	public AccountMasterQueryRes queryAccount_1(AccountMasterQueryReq accounMasterQyrreq);
	public AccountMasterQueryRes queryAccount_2(String  accountNo);

}
