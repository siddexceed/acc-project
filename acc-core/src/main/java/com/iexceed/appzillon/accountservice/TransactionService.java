package com.iexceed.appzillon.accountservice;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.iexceed.appzillon.entity.TbAccountMaster;
import com.iexceed.appzillon.entity.TbTransactionMaster;
import com.iexceed.appzillon.jaxb.AccountCreationReq;
import com.iexceed.appzillon.jaxb.AccountCreationRes;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteReq;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteRes;
import com.iexceed.appzillon.jaxb.AccountMasterQueryReq;
import com.iexceed.appzillon.jaxb.AccountMasterQueryRes;
import com.iexceed.appzillon.jaxb.TransactionMasterCreateReq;
import com.iexceed.appzillon.jaxb.TransactionMasterCreateRes;
import com.iexceed.appzillon.jaxb.TransactionMasterQueryReq;
import com.iexceed.appzillon.jaxb.TransactionMasterQueryRes;
import com.iexceed.appzillon.repository.AccountTransactionRepository;
import com.iexceed.appzillon.utils.LoggerUtils;

@Named("TransactionService")
@Transactional
public class TransactionService {

	public static Logger log = LoggerUtils.getLogger();
	
	@Inject
	AccountTransactionRepository actrarepo; 
	
	public String queryTransaction() {
		return "Success";
	}
	
	public TransactionMasterCreateRes saveTransaction(TransactionMasterCreateReq transcreatereq) {
		log.info("Inside Save Account of TransactionService");
		TransactionMasterCreateRes tmastcreateres = new TransactionMasterCreateRes();
		TbTransactionMaster transactMaster = new TbTransactionMaster();
		log.debug("Acc NO:::" +transcreatereq.getAccountNum() );
		log.debug("Acc Name:::" + transcreatereq.getTransactionAmt());
		log.debug("Acc type:::" +transcreatereq.getTransactionCode() );
		log.debug("Acc currency:::" +transcreatereq.getTransactionDesc() );
		log.debug("currentbal:::" + transcreatereq.getTransactionId());
		log.debug("lineamt:::" +transcreatereq.getTransactionType() );
		log.debug("clearingamt:::" +transcreatereq.getTransactionCurrency() );
		log.debug("withdrawablebal:::" +transcreatereq.getTransactionDate() );
		transactMaster.setAccountNum(transcreatereq.getAccountNum());
		transactMaster.setTransactionAmt(transcreatereq.getTransactionAmt());
		transactMaster.setTransactionCode(transcreatereq.getTransactionCode());
		transactMaster.setTransactionCurrency(transcreatereq.getTransactionCurrency());
		transactMaster.setTransactionDate(transcreatereq.getTransactionDate());
		transactMaster.setTransactionDesc(transcreatereq.getTransactionDesc());
		transactMaster.setTransactionId(transcreatereq.getTransactionId());
		transactMaster.setTransactionType(transcreatereq.getTransactionType());
		actrarepo.save(transactMaster);
		tmastcreateres.setMessage("Success");
		log.info("Leaving Save Account");
		return tmastcreateres;
	}
	
	
	public TransactionMasterQueryRes queryTransaction(TransactionMasterQueryReq accqueryreq) {
		log.info("Inside query Account");
		TransactionMasterQueryRes transMasterqryres = new TransactionMasterQueryRes();
		TbTransactionMaster transMaster=actrarepo.findOne(accqueryreq.getAccountNum());
		log.debug("Acc Number:::" + transMaster.getAccountNum());
		log.debug("Transaction amount:::" + transMaster.getTransactionAmt());
		log.debug("Transaction code:::" + transMaster.getTransactionCode());
		log.debug("Transact currency:::" + transMaster.getTransactionCurrency());
		log.debug("Transact description:::" + transMaster.getTransactionDesc());
		log.debug("Transact Id:::" + transMaster.getTransactionId());
		log.debug("Transact Type:::" + transMaster.getTransactionType());
		log.debug("Transact Date:::" + transMaster.getTransactionDate());
		transMasterqryres.setAccountNum(transMaster.getAccountNum());
		transMasterqryres.setTransactionAmt(transMaster.getTransactionAmt());
		transMasterqryres.setTransactionCode(transMaster.getTransactionCode());
		transMasterqryres.setTransactionCurrency(transMaster.getTransactionCurrency());
		transMasterqryres.setTransactionDate(transMaster.getTransactionDate());
		transMasterqryres.setTransactionDesc(transMaster.getTransactionDesc());
		transMasterqryres.setTransactionId(transMaster.getTransactionId());
		transMasterqryres.setTransactionType(transMaster.getTransactionType());
		log.info("Leaving Query Account");
		return transMasterqryres;
	}

}
