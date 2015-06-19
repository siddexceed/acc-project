package com.iexceed.appzillon.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import com.iexceed.appzillon.accountservice.ServiceController;
import com.iexceed.appzillon.accountservice.TransactionService;
import com.iexceed.appzillon.jaxb.TransactionMasterQueryReq;
import com.iexceed.appzillon.jaxb.TransactionMasterQueryRes;
import com.iexceed.appzillon.utils.LoggerUtils;


@WebService(name = "TransactionService11", serviceName = "TransactionService11", targetNamespace = "http://www.iexceed.com")
@BindingType(value = SOAPBinding.SOAP11HTTP_BINDING)
public class TransactionService11Impl {
	public static Logger log = LoggerUtils.getLogger();
	@WebMethod
	@WebResult(name = "TransactionMasterCreateRes")
	public TransactionMasterQueryRes transactionQuery(
			@WebParam(name = "TransactionMasterQueryReq") TransactionMasterQueryReq txnQueryReq) {
		log.debug("Entered Soap Service");
		TransactionService txnService = (TransactionService) ServiceController
				.getInstance().getService("TransactionService");
		log.debug("Account Service Injected::" + txnService);
		return txnService.queryTransaction(txnQueryReq);
	}
}
