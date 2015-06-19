package com.iexceed.appzillon.accountservice;

import java.math.BigDecimal;
import java.sql.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.iexceed.appzillon.entity.TbAccountMaster;
import com.iexceed.appzillon.jaxb.AccountCreationReq;
import com.iexceed.appzillon.jaxb.AccountCreationRes;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteReq;
import com.iexceed.appzillon.jaxb.AccountMasterDeleteRes;
import com.iexceed.appzillon.jaxb.AccountMasterQueryReq;
import com.iexceed.appzillon.jaxb.AccountMasterQueryRes;
import com.iexceed.appzillon.repository.AccountsRepositroy;
import com.iexceed.appzillon.utils.JAXBUtils;
import com.iexceed.appzillon.utils.LoggerUtils;

@Named("AccountService")
@Transactional
public class AccountService {

    public static Logger log = LoggerUtils.getLogger();

    @Inject
    AccountsRepositroy accRepo;

    public AccountCreationRes saveAccount(AccountCreationReq accCreatereq) {
        log.info("Inside Save Account");
        AccountCreationRes accountCreateres = new AccountCreationRes();
        TbAccountMaster TbAccountMaster = new TbAccountMaster();
        log.debug("Acc NO:::" + accCreatereq.getAccountNum());
        log.debug("Acc Name:::" + accCreatereq.getAccountName());
        log.debug("Acc type:::" + accCreatereq.getAccountType());
        log.debug("Acc currency:::" + accCreatereq.getAccountCurrency());
        log.debug("currentbal:::" + accCreatereq.getCurrentBal());
        log.debug("lineamt:::" + accCreatereq.getLineAmt());
        log.debug("clearingamt:::" + accCreatereq.getClearingAmt());
        log.debug("withdrawablebal:::" + accCreatereq.getWithdrawableBal());
        log.debug("creationdate:::" + accCreatereq.getCreationDate());
        log.debug("last transaction date:::"
                + accCreatereq.getLastTransactionDate());
        log.debug("Acc Address:::" + accCreatereq.getAccountAddress());
        log.debug("Acc CustomerId:::" + accCreatereq.getCustomerId());
        TbAccountMaster.setAccountNum(accCreatereq.getAccountNum());
        TbAccountMaster.setAccountName(accCreatereq.getAccountName());
        TbAccountMaster.setAccountType(accCreatereq.getAccountType());
        TbAccountMaster.setAccountCurrency(accCreatereq.getAccountCurrency());
        TbAccountMaster.setCurrentBal(accCreatereq.getCurrentBal()
                .doubleValue());
        TbAccountMaster.setLineAmt(accCreatereq.getLineAmt().doubleValue());
        TbAccountMaster.setClearingAmt(accCreatereq.getClearingAmt()
                .doubleValue());
        TbAccountMaster.setWithdrawbleBal(accCreatereq.getWithdrawableBal()
                .doubleValue());
        TbAccountMaster.setCreationDate(new Date(System.currentTimeMillis()));
        TbAccountMaster.setLastTransactionDate(new Date(System
                .currentTimeMillis()));
        TbAccountMaster.setAccountAddress(accCreatereq.getAccountAddress());
        TbAccountMaster.setCustomerId(accCreatereq.getCustomerId());
        accRepo.save(TbAccountMaster);
        accountCreateres.setMessage("Success");
        log.info("Leaving Save Account");
        return accountCreateres;
    }

    public AccountMasterDeleteRes deleteAccount(
            AccountMasterDeleteReq accdeletereq) {
        log.info("Inside Delete Account");
        AccountMasterDeleteRes accountDeleteRes = new AccountMasterDeleteRes();
        log.debug("Acc NO:::" + accdeletereq.getAccountNum());
        accRepo.delete(accdeletereq.getAccountNum());
        accountDeleteRes.setMessage("Success");
        log.info("Leaving Save Account");
        return accountDeleteRes;
    }

    public AccountMasterQueryRes queryAccount(AccountMasterQueryReq accqueryreq) {
        log.info("Inside query Account");
        AccountMasterQueryRes accountqueryRes = new AccountMasterQueryRes();
        TbAccountMaster accountMaster = accRepo.findOne(accqueryreq
                .getAccountNum());
        log.debug("Acc Address:::" + accountMaster.getAccountAddress());
        log.debug("Acc Currency:::" + accountMaster.getAccountCurrency());
        log.debug("Acc Name:::" + accountMaster.getAccountName());
        log.debug("Acc Number:::" + accountMaster.getAccountNum());
        log.debug("Acc Type:::" + accountMaster.getAccountType());
        log.debug("clearing Amt:::" + accountMaster.getClearingAmt());
        log.debug("Creation Date:::" + accountMaster.getCreationDate());
        log.debug("current Bal:::" + accountMaster.getCurrentBal());
        log.debug("cust Id:::" + accountMaster.getCustomerId());
        log.debug("last transaction date:::"
                + accountMaster.getLastTransactionDate());
        log.debug("Line Amnt:::" + accountMaster.getLineAmt());
        log.debug("withdrawable bal:::" + accountMaster.getWithdrawbleBal());

        accountqueryRes.setAccountAddress(accountMaster.getAccountAddress());
        accountqueryRes.setAccountCurrency(accountMaster.getAccountCurrency());
        accountqueryRes.setAccountName(accountMaster.getAccountName());
        accountqueryRes.setAccountNum(accountMaster.getAccountNum());
        accountqueryRes.setAccountType(accountMaster.getAccountType());
        accountqueryRes.setClearingAmt(new BigDecimal(accountMaster
                .getClearingAmt()));
        accountqueryRes.setCreationDate(accountMaster.getCreationDate());
        accountqueryRes.setCurrentBal(new BigDecimal(accountMaster
                .getCurrentBal()));
        accountqueryRes.setCustomerId(accountMaster.getCustomerId());
        accountqueryRes.setLastTransactionDate(accountMaster
                .getLastTransactionDate());
        accountqueryRes.setLineAmt(new BigDecimal(accountMaster.getLineAmt()));
        accountqueryRes.setWithdrawableBal(new BigDecimal(accountMaster
                .getWithdrawbleBal()));

        log.info("Leaving Save Account");
        return accountqueryRes;
    }

    public AccountMasterQueryRes queryAccount(String accountNo) {
        // TODO Auto-generated method stub
        AccountMasterQueryRes accountqueryRes = new AccountMasterQueryRes();
        TbAccountMaster accountMaster = accRepo.findOne(accountNo);
        log.debug("Acc Address:::" + accountMaster.getAccountAddress());
        log.debug("Acc Currency:::" + accountMaster.getAccountCurrency());
        log.debug("Acc Name:::" + accountMaster.getAccountName());
        log.debug("Acc Number:::" + accountMaster.getAccountNum());
        log.debug("Acc Type:::" + accountMaster.getAccountType());
        log.debug("clearing Amt:::" + accountMaster.getClearingAmt());
        log.debug("Creation Date:::" + accountMaster.getCreationDate());
        log.debug("current Bal:::" + accountMaster.getCurrentBal());
        log.debug("cust Id:::" + accountMaster.getCustomerId());
        log.debug("last transaction date:::"
                + accountMaster.getLastTransactionDate());
        log.debug("Line Amnt:::" + accountMaster.getLineAmt());
        log.debug("withdrawable bal:::" + accountMaster.getWithdrawbleBal());

        accountqueryRes.setAccountAddress(accountMaster.getAccountAddress());
        accountqueryRes.setAccountCurrency(accountMaster.getAccountCurrency());
        accountqueryRes.setAccountName(accountMaster.getAccountName());
        accountqueryRes.setAccountNum(accountMaster.getAccountNum());
        accountqueryRes.setAccountType(accountMaster.getAccountType());
        accountqueryRes.setClearingAmt(new BigDecimal(accountMaster
                .getClearingAmt()));
        accountqueryRes.setCreationDate(accountMaster.getCreationDate());
        accountqueryRes.setCurrentBal(new BigDecimal(accountMaster
                .getCurrentBal()));
        accountqueryRes.setCustomerId(accountMaster.getCustomerId());
        accountqueryRes.setLastTransactionDate(accountMaster
                .getLastTransactionDate());
        accountqueryRes.setLineAmt(new BigDecimal(accountMaster.getLineAmt()));
        accountqueryRes.setWithdrawableBal(new BigDecimal(accountMaster
                .getWithdrawbleBal()));

        log.info("Leaving Save Account");
        return accountqueryRes;
    }

   

}
